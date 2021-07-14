package impl.domain;

import Service.domain.FilePathEnitySevice;
import Service.excute.ProxyExcute;
import Service.excute.factory.SearchExcuteFactory;
import com.sun.istack.internal.NotNull;
import enity.FilePathEnity;
import utill.FIleUnit;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FilePathEnitySeviceImpl implements FilePathEnitySevice {

    private String path;

    private ProxyExcute proxyExcute;

    /**
     * 初始化，获取存储设备工具
     */
    public FilePathEnitySeviceImpl(){

        this.path="";


    }

    @Override
    public FilePathEnity findAll() {

        FilePathEnity filePathEnity=null;

        if(this.path.equals("")){
            File[] roots=File.listRoots();
            if(roots!=null){
                List<FilePathEnity> filePathEnities=new ArrayList<>();
                for(File file:roots){
                    FilePathEnity filePathEnitytemp=findAllUnit(file);
                    if(filePathEnities!=null){
                        filePathEnities.add(filePathEnitytemp);
                    }
                    filePathEnity=new FilePathEnity(this.path,null,filePathEnities, FIleUnit.judgeFileType(file));
                }
            }
        }else {
            File file=new File(this.path);
            if(file!=null){
                filePathEnity=findAllUnit(file);
            }
        }

        return filePathEnity;

    }

    private FilePathEnity findAllUnit(@NotNull File file){
        FilePathEnity filePathEnity=null;
        File[] files=file.listFiles();
        List<FilePathEnity> filePathEnities=new ArrayList<>();

        if(files!=null && files.length>0){

            for(File fileUnit:files){
                FilePathEnity filePathEnitytemp=findAllUnit(fileUnit);
                if(filePathEnitytemp!=null){
                    filePathEnities.add(filePathEnitytemp);
                }
            }
        }
        filePathEnity=new FilePathEnity(file.getPath(),null,filePathEnities,FIleUnit.judgeFileType(file));

        return filePathEnity;
    }

    @Override
    public FilePathEnity findAll(@NotNull String path) {

        this.path=path;
        return findAll();
    }

    @Override
    public FilePathEnity findCurrentPath(String path) {
        return null;
    }

    @Override
    public FilePathEnity findCurrentPath() {
        return null;
    }

    @Override
    public List<FilePathEnity> findLeafFile() {
        return null;
    }

    @Override
    public List<FilePathEnity> findLeafFile(String path) {
        return null;
    }

    @Override
    public List<FilePathEnity> releaseFilePath() {
        return null;
    }

    @Override
    public List<FilePathEnity> releaseFilePath(String path) {
        return null;
    }

    @Override
    public FilePathEnitySevice traversalAll(String path,String searchExcuteImplName) {
        SearchExcuteFactory searchExcuteFactory=new SearchExcuteFactory();
        proxyExcute=searchExcuteFactory.getPorduct(searchExcuteImplName);

        if(path.equals("")){

            File[] roots=File.listRoots();
            for(File file:roots){
                traversalAllUnit(file.getPath());
            }

        }else{

            traversalAllUnit(path);

        }
        return null;
    }

    private void traversalAllUnit(String path){

        if(proxyExcute==null){
            return;
        }

        File dir=new File(path);

        File[] files=dir.listFiles();

        this.path=path;

        FilePathEnity filePathEnity=findCurrentPath();

        try {
            proxyExcute.Excute(filePathEnity);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(dir.isFile()){
            return;
        }

        if(files==null || files.length==0){

            return;

        }else {

            for(File file:files){
                traversalAllUnit(file.getPath());
            }

        }

    }

    @Override
    public FilePathEnitySevice traversalAll(String path) {
        return null;
    }

    @Override
    public FilePathEnitySevice traversalCurrentPath(String path, String searchExcuteImplName) {
        return null;
    }

    @Override
    public FilePathEnitySevice traversalCurrentPath(String searchExcuteImplName) {
        return null;
    }

    @Override
    public FilePathEnitySevice traversalLeafFile(String path, String searchExcuteImplName) {
        return null;
    }

    @Override
    public FilePathEnitySevice traversalLeafFile(String searchExcuteImplName) {
        return null;
    }




}
