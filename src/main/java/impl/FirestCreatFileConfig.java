package impl;

import Service.systemlevel.FileConfigService;
import com.alibaba.fastjson.JSONObject;
import enity.FilePathEnity;
import enity.PathConfigEnity;
import enity.PathUnitConfigEnity;
import utill.FIleUnit;
import utill.StringUnit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FirestCreatFileConfig implements FileConfigService {
    @Override
    public boolean createFileConfig(FilePathEnity filePathEnity) throws IOException {
        /*
        获取主路径
         */
        String locationPath=filePathEnity.getAbsolutePath();

        List<String> locationPathSplits=StringUnit.stringSplit(locationPath,"\\\\");

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
}
