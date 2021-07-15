package impl.domain;

import Service.domain.FilePathEnitySevice;
import Service.excute.ProxyExcute;
import Service.excute.factory.SearchExcuteFactory;
import com.sun.istack.internal.NotNull;
import enity.FilePathEnity;
import utill.FIleUnit;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
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
                }
                filePathEnity=new FilePathEnity(this.path,null,filePathEnities, 1);
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
    public FilePathEnity findCurrentPath(@NotNull String path) {
        this.path=path;
        return findCurrentPath();
    }

    @Override
    public FilePathEnity findCurrentPath() {
        FilePathEnity filePathEnity=null;
        if(this.path.equals("")){

            File[] roots=File.listRoots();
            if(roots!=null){
                List<FilePathEnity> filePathEnities=new ArrayList<>();
                for(File file:roots){
                    FilePathEnity filePathEnitytemp=new FilePathEnity(file.getPath(),null,null,FIleUnit.judgeFileType(file));
                    if(filePathEnities!=null){
                        filePathEnities.add(filePathEnitytemp);
                    }
                    filePathEnity=new FilePathEnity(this.path,null,filePathEnities, FIleUnit.judgeFileType(file));
                }
            }

        }else{
            File file=new File(this.path);
            File[] files=file.listFiles();
            List<FilePathEnity> filePathEnities=new ArrayList<>();

            if(files!=null && files.length>0){

                for(File fileUnit:files){

                    FilePathEnity filePathEnitytemp=new FilePathEnity(fileUnit.getPath(),null,null,FIleUnit.judgeFileType(fileUnit));
                    filePathEnities.add(filePathEnitytemp);

                }
            }
            filePathEnity=new FilePathEnity(this.path,null,filePathEnities,FIleUnit.judgeFileType(file));
        }
        return filePathEnity;
    }

    @Override
    public List<FilePathEnity> findLeafFile() {
        List<FilePathEnity> filePathEnities=new ArrayList<>();
        if(this.path.equals("")){
            File[] roots=File.listRoots();
            if(roots!=null){
                for(File file:roots){
                    findLeafFileUnit(file,filePathEnities);
                }
            }
        }else{
            File file=new File(this.path);
            File[] files=file.listFiles();
            if(files!=null&&files.length>0){
                for(File fileUnit:files){
                    findLeafFileUnit(fileUnit,filePathEnities);
                }
            }
        }
        return filePathEnities;
    }

    @Override
    public List<FilePathEnity> findLeafFile(String path) {
        this.path=path;
        return findLeafFile();
    }

    private void findLeafFileUnit(File file,List<FilePathEnity> filePathEnities){
        if(FIleUnit.judgeFileType(file)==1){
            //进行字典遍历
            File[] files=file.listFiles();
            if (files!=null&&files.length>0){
                for(File fileUnit:files){
                    findLeafFileUnit(fileUnit,filePathEnities);
                }
            }
        }else{
            filePathEnities.add(
                    new FilePathEnity(file.getPath(),null,null,FIleUnit.judgeFileType(file))
            );
        }
        return;
    }

    @Override
    public FilePathEnitySevice traversalAll(String searchExcuteImplName) {
        SearchExcuteFactory searchExcuteFactory=new SearchExcuteFactory();
        proxyExcute=searchExcuteFactory.getPorduct(searchExcuteImplName);

        if(this.path.equals("")){

            File[] roots=File.listRoots();
            for(File file:roots){
                traversalAllUnit(file.getPath());
            }

        }else{

            traversalAllUnit(this.path);

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
    public FilePathEnitySevice traversalAll(String path,String searchExcuteImplName) {
        this.path=path;
        return traversalAll(searchExcuteImplName);
    }

    @Override
    public FilePathEnitySevice traversalCurrentPath(String path, String searchExcuteImplName) {

        if(this.path.equals("")){

            File[] roots=File.listRoots();
            if(roots!=null){

                for(File file:roots){

                }
            }

        }else{
            File file=new File(this.path);
            File[] files=file.listFiles();
            List<FilePathEnity> filePathEnities=new ArrayList<>();

            if(files!=null && files.length>0){

                for(File fileUnit:files){

                    FilePathEnity filePathEnitytemp=new FilePathEnity(fileUnit.getPath(),null,null,FIleUnit.judgeFileType(fileUnit));
                    filePathEnities.add(filePathEnitytemp);

                }
            }
            filePathEnity=new FilePathEnity(this.path,null,filePathEnities,FIleUnit.judgeFileType(file));
        }
        return filePathEnity;
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
