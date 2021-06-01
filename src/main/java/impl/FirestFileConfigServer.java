package impl;

import Service.systemlevel.FileConfigService;
import com.sun.istack.internal.NotNull;
import enity.PathConfigEnity;
import enity.PathUnitConfigEnity;

import Service.FileConfigServer;
import utill.FIleUnit;
import utill.StringUnit;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirestFileConfigServer implements FileConfigServer {

    @Override
    public boolean ishasFLP(String FilePath) {
        if(StringUnit.isEmpty(FilePath)){
            return false;
        }

        List<String> stringList= StringUnit.stringSplit(FilePath,"////");

        String path="";
        if(stringList.size()>0){
            path=FilePath+"//"+stringList.get(stringList.size());
        }else {
            return false;
        }

        File file=new File(path);
        if(file.exists()){
            return true;
        }

        return false;
    }

    @Override
    public boolean isEqualMd5(String filePath, String Md5) {

        if(StringUnit.hasEmptyOne(filePath,Md5)){
            return false;
        }

        if(Md5.equals(FIleUnit.getMd5(filePath))){
            return true;
        }

        return false;
    }

    @Override
    public boolean isOver(@NotNull PathUnitConfigEnity pathUnitConfigEnity) {

        return pathUnitConfigEnity.isBolnUpdata();

    }

    @Override
    public boolean isNewAdd(@NotNull PathConfigEnity pathConfigEnity, String path) {

        if(pathConfigEnity!=null){
            for(PathUnitConfigEnity pathUnitConfigEnity:pathConfigEnity.getPathUnitConfigEnityList()){
                if(pathUnitConfigEnity.getLocationPath().equals(path)){
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public boolean addNewOne(@NotNull PathConfigEnity pathConfigEnity, String path) throws IOException {

        List<PathUnitConfigEnity> pathUnitConfigEnities=pathConfigEnity.getPathUnitConfigEnityList();

        FirestCreatFileConfig firestCreatFileConfig=new FirestCreatFileConfig();

        PathUnitConfigEnity pathUnitConfigEnity=firestCreatFileConfig.buildPathUnitConfigEnity(
                new File(path).isFile(),
                false,false,
                path,true,"");

        pathUnitConfigEnities.add(pathUnitConfigEnity);

        pathConfigEnity.setPathUnitConfigEnityList(pathUnitConfigEnities);

        FileConfigService createFileConfig=new FirestCreatFileConfig();

        createFileConfig.createFileConfig(pathConfigEnity);

        return true;

    }

    /**
     * 如果需要的话需要写一个查重的函数
     * @param pathConfigEnity
     * @return
     */
    @Override
    public Map<String, PathUnitConfigEnity> whatNewAdd(@NotNull PathConfigEnity pathConfigEnity) {

        Map<String,PathUnitConfigEnity> result=new HashMap<>();

        List<PathUnitConfigEnity> pathUnitConfigEnities=pathConfigEnity.getPathUnitConfigEnityList();

        File file=new File(pathConfigEnity.getLocationPath());

        File[] files=file.listFiles();

        FirestCreatFileConfig firestCreatFileConfig=new FirestCreatFileConfig();

        for(File fileUnit:files){

            PathUnitConfigEnity pathUnitConfigEnity=firestCreatFileConfig.buildPathUnitConfigEnity(
                    fileUnit.isFile(),
                    false,false,
                    fileUnit.getPath(),true,"");

            result.put(fileUnit.getPath(),pathUnitConfigEnity);
        }

        for(PathUnitConfigEnity pathUnitConfigEnity:pathUnitConfigEnities){

            result.remove(pathUnitConfigEnity.getLocationPath());

        }

        return result;
    }

    @Override
    public boolean addNewMap(@NotNull PathConfigEnity pathConfigEnity, @NotNull Map<String, PathUnitConfigEnity> pathUnitConfigEnityMap) throws IOException {

        List<PathUnitConfigEnity> pathUnitConfigEnities=pathConfigEnity.getPathUnitConfigEnityList();

        FirestCreatFileConfig firestCreatFileConfig=new FirestCreatFileConfig();

        for(String path:pathUnitConfigEnityMap.keySet()){

            pathUnitConfigEnities.add(pathUnitConfigEnityMap.get(path));

        }

        pathConfigEnity.setPathUnitConfigEnityList(pathUnitConfigEnities);

        firestCreatFileConfig.createFileConfig(pathConfigEnity);

        return false;
    }


}
