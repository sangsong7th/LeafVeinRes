package impl.systemlevel;

import Service.systemlevel.FileConfigService;
import com.alibaba.fastjson.JSONObject;
import com.sun.istack.internal.NotNull;
import enity.FilePathEnity;
import enity.PathConfigEnity;
import enity.PathUnitConfigEnity;
import utill.FIleUnit;
import utill.StringUnit;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileConfigServiceImpl implements FileConfigService {

    @Override
    public boolean createFileConfig(FilePathEnity filePathEnity) throws IOException {
        /*
        获取主路径
         */
        String locationPath=filePathEnity.getAbsolutePath();

        List<String> locationPathSplits= StringUnit.stringSplit(locationPath,"\\\\");

        PathConfigEnity pathConfigEnity=buildPathConfigEnity(filePathEnity,false,false,false,
                false,false,false,
                "",null,"",
                "",null,"",null);


        String result= JSONObject.toJSONString(pathConfigEnity);

        FIleUnit.outputJSONString(result,locationPath+"\\"+locationPathSplits.get(locationPathSplits.size()-1)+".FLP");

        return true;
    }

    @Override
    public boolean createFileConfig(PathConfigEnity pathConfigEnity) throws IOException {
        List<String> locationPathSplits=StringUnit.stringSplit(pathConfigEnity.getLocationPath(),"\\\\");
        String result= JSONObject.toJSONString(pathConfigEnity);
        FIleUnit.outputJSONString(result,pathConfigEnity.getLocationPath()+"\\"+locationPathSplits.get(locationPathSplits.size()-1)+".FLP");
        return true;
    }


    public PathConfigEnity buildPathConfigEnity (FilePathEnity filePathEnity,
                                                 boolean bolnClassRoot,
                                                 boolean bolnDistributeDir,
                                                 boolean bolnMaster,
                                                 boolean bolnSlave,
                                                 boolean bolnUpdataOver,
                                                 boolean bolnVirPath,
                                                 String classpath,
                                                 List<String> distributedDir,
                                                 String hashcode,
                                                 String masterDir,
                                                 List<String> slaveDir,
                                                 String virClassPath,
                                                 List<String> virClassPaths){
        PathConfigEnity pathConfigEnity=new PathConfigEnity();

        String LocatPath=filePathEnity.getAbsolutePath();

        pathConfigEnity.setBolnClassRoot(bolnClassRoot);
        pathConfigEnity.setBolnDistributeDir(bolnDistributeDir);
        pathConfigEnity.setBolnMaster(bolnMaster);
        pathConfigEnity.setBolnSlave(bolnSlave);
        pathConfigEnity.setBolnUpdataOver(bolnUpdataOver);
        pathConfigEnity.setBolnVirPath(bolnVirPath);
        pathConfigEnity.setClassPath(classpath);

        if(bolnDistributeDir) {
            pathConfigEnity.setDistributedDir(distributedDir);
        }else{
            pathConfigEnity.setDistributedDir(null);
        }

        pathConfigEnity.setHashcode(hashcode);
        pathConfigEnity.setLocationPath(LocatPath);
        pathConfigEnity.setMasterDir(masterDir);

        pathConfigEnity.setSlaveDir(slaveDir);
        pathConfigEnity.setVirClassPath(virClassPath);
        pathConfigEnity.setVirClassPaths(virClassPaths);

        List<PathUnitConfigEnity> pathUnitConfigEnityList=new ArrayList<>();

        for(FilePathEnity filePathEnityUnit:filePathEnity.getFiles()){
            PathUnitConfigEnity pathUnitConfigEnity=buildPathUnitConfigEnity(
                    filePathEnityUnit.getIsFile()==1?false:true,
                    false,false,
                    filePathEnityUnit.getAbsolutePath(),true,"");
            pathUnitConfigEnityList.add(pathUnitConfigEnity);
        }

        pathConfigEnity.setPathUnitConfigEnityList(pathUnitConfigEnityList);

        return pathConfigEnity;

    }

    public PathUnitConfigEnity buildPathUnitConfigEnity(boolean bolnDir, boolean bolnVir, boolean bolnUpdata, String path,
                                                        boolean scannerDir, String truePath){
        PathUnitConfigEnity unitConfigEnity=new PathUnitConfigEnity();
        unitConfigEnity.setBolnDir(bolnDir);
        unitConfigEnity.setBolnVir(bolnVir);
        unitConfigEnity.setBolnUpdata(bolnUpdata);
        List<String> paths=StringUnit.stringSplit(path,"\\\\");

        String locationPath="";
        for(int i=0;i<paths.size()-1;i++){
            locationPath=locationPath+paths.get(i)+"\\";
        }

        unitConfigEnity.setLocationPath(locationPath);

        if(!bolnDir) {

            unitConfigEnity.setMd5(FIleUnit.getMd5(path));


            unitConfigEnity.setSize(FIleUnit.getSize(path));

        }

        unitConfigEnity.setName(paths.get(paths.size()-1));

        unitConfigEnity.setScannerDir(scannerDir);

        unitConfigEnity.setTruePath(truePath);


        return unitConfigEnity;
    }


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


        PathUnitConfigEnity pathUnitConfigEnity=buildPathUnitConfigEnity(
                new File(path).isFile(),
                false,false,
                path,true,"");

        pathUnitConfigEnities.add(pathUnitConfigEnity);

        pathConfigEnity.setPathUnitConfigEnityList(pathUnitConfigEnities);

        createFileConfig(pathConfigEnity);

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


        for(File fileUnit:files){

            PathUnitConfigEnity pathUnitConfigEnity=buildPathUnitConfigEnity(
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



        for(String path:pathUnitConfigEnityMap.keySet()){

            pathUnitConfigEnities.add(pathUnitConfigEnityMap.get(path));

        }

        pathConfigEnity.setPathUnitConfigEnityList(pathUnitConfigEnities);

        createFileConfig(pathConfigEnity);

        return false;
    }


}
