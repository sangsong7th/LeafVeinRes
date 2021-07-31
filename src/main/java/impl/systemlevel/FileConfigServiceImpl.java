package impl.systemlevel;

import service.domain.FilePathEnitySevice;
import service.systemlevel.FileConfigService;
import com.alibaba.fastjson.JSONObject;
import com.sun.istack.internal.NotNull;
import enity.FilePathEnity;
import enity.PathConfigEnity;
import enity.PathUnitConfigEnity;
import impl.domain.FilePathEnitySeviceImpl;
import utill.FileUnit;
import utill.StringUnit;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileConfigServiceImpl implements FileConfigService {

    private FilePathEnitySevice filePathEnitySevice=new FilePathEnitySeviceImpl();

    @Override
    public boolean createFileConfig(FilePathEnity filePathEnity) throws IOException {
        /**
         * 判断是否是文件路径
         */
        if(filePathEnity.getFileType()!=1){
            return false;
        }
        /*
        获取主路径
         */
        String locationPath=filePathEnity.getAbsolutePath();


        List<String> locationPathSplits= StringUnit.stringSplit(locationPath,"\\\\");

        PathConfigEnity pathConfigEnity=buildPathConfigEnity(filePathEnity);

        String result= JSONObject.toJSONString(pathConfigEnity);

        FileUnit.outputJSONString(result,locationPath+"\\"+locationPathSplits.get(locationPathSplits.size()-1)+".FLP");

        return true;
    }

    @Override
    public boolean createFileConfig(PathConfigEnity pathConfigEnity) throws IOException {
        List<String> locationPathSplits=StringUnit.stringSplit(pathConfigEnity.getLocationPath(),"\\\\");
        String result= JSONObject.toJSONString(pathConfigEnity);
        FileUnit.outputJSONString(result,pathConfigEnity.getLocationPath()+"\\"+locationPathSplits.get(locationPathSplits.size()-1)+".FLP");
        return true;
    }

    @Override
    public boolean createFileConfig(String filePath) throws IOException {
        filePathEnitySevice.traversalAllDir(filePath,"ExcuteForCreateFileConfig");
        return true;
    }


    public PathConfigEnity buildPathConfigEnity (FilePathEnity filePathEnity){
        PathConfigEnity pathConfigEnity=new PathConfigEnity();

        String locatPath=filePathEnity.getAbsolutePath();

        pathConfigEnity.setLocationPath(locatPath);

        List<PathUnitConfigEnity> pathUnitConfigEnityList=new ArrayList<>();

        for(FilePathEnity filePathEnityUnit:filePathEnity.getFiles()){
            PathUnitConfigEnity pathUnitConfigEnity=buildPathUnitConfigEnity(
                    filePathEnityUnit.getFileType()==0?false:true,
                    filePathEnityUnit.getAbsolutePath(),filePathEnityUnit.getAbsolutePath());
            pathUnitConfigEnityList.add(pathUnitConfigEnity);
        }

        pathConfigEnity.setPathUnitConfigEnityList(pathUnitConfigEnityList);

        return pathConfigEnity;

    }

    public PathUnitConfigEnity buildPathUnitConfigEnity(boolean bolnDir, String path,
                                                        String truePath){
        PathUnitConfigEnity unitConfigEnity=new PathUnitConfigEnity();
        unitConfigEnity.setBolnDir(bolnDir);
        List<String> paths=StringUnit.stringSplit(path,"\\\\");

        String locationPath="";
        for(int i=0;i<paths.size()-1;i++){
            locationPath=locationPath+paths.get(i)+"\\";
        }

        unitConfigEnity.setLocationPath(locationPath);

        if(!bolnDir) {

            unitConfigEnity.setMd5(FileUnit.getMd5(path));
            unitConfigEnity.setSize(FileUnit.getSize(path));

        }

        unitConfigEnity.setName(paths.get(paths.size()-1));


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

        if(Md5.equals(FileUnit.getMd5(filePath))){
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
