package impl.domain;

import Service.domain.FilePathEnitySevice;
import Service.excute.ProxyExcute;
import Service.excute.factory.ExcuteFactory;
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
    public FilePathEnitySevice traversalAllDir(String searchExcuteImplName) throws IOException {

        proxyExcute= ExcuteFactory.getPorduct(searchExcuteImplName);

        if(this.path.equals("")){

            File[] roots=File.listRoots();
            for(File file:roots){
                traversalAllUnitDir(file);
            }

        }else{

            traversalAllUnitDir(new File(this.path));

        }
        return this;
    }



    private void traversalAllUnitDir(File file) throws IOException {

        if(proxyExcute==null){
            return;
        }

        if(file.isFile()){
            return;
        }

        proxyExcute.Excute(file);

        File[] files=file.listFiles();


        if(files==null || files.length==0){

            return;

        }else {

            for(File fileUnit:files){
                traversalAllUnitDir(fileUnit);
            }

        }

    }

    @Override
    public FilePathEnitySevice traversalAllDir(String path, String searchExcuteImplName) throws IOException {
        this.path=path;
        return traversalAllDir(searchExcuteImplName);
    }

    @Override
    public FilePathEnitySevice traversalAll(String path, String searchExcuteImplName) throws IOException {
        this.path=path;
        return traversalAll(searchExcuteImplName);
    }

    @Override
    public FilePathEnitySevice traversalAll(String searchExcuteImplName) throws IOException {

        proxyExcute=ExcuteFactory.getPorduct(searchExcuteImplName);
        if(this.path.equals("")){

            File[] roots=File.listRoots();
            for(File file:roots){
                traversalAllUnit(file);
            }

        }else{

            traversalAllUnit(new File(this.path));

        }
        return this;
    }

    private void traversalAllUnit(File file) throws IOException {

        if(proxyExcute==null){
            return;
        }



        if(file.isFile()){
            return;
        }


        File[] files=file.listFiles();



        if(files==null || files.length==0){

            return;

        }else {

            for(File fileUnit:files){

                proxyExcute.Excute(fileUnit);

                traversalAllUnit(fileUnit);
            }

        }

    }

    @Override
    public FilePathEnitySevice traversalCurrentPath(String searchExcuteImplName) throws IOException {

        proxyExcute=ExcuteFactory.getPorduct(searchExcuteImplName);

        if(this.path.equals("")){

            File[] roots=File.listRoots();
            if(roots!=null){

                for(File fileUnit:roots){
                    proxyExcute.Excute(fileUnit);
                }
            }

        }else{
            File file=new File(this.path);
            File[] files=file.listFiles();

            if(files!=null && files.length>0){

                for(File fileUnit:files){
                    proxyExcute.Excute(fileUnit);
                }
            }

        }
        return this;
    }

    @Override
    public FilePathEnitySevice traversalCurrentPath(String path, String searchExcuteImplName) throws IOException {
        this.path=path;
        return traversalCurrentPath(searchExcuteImplName);
    }

    @Override
    public FilePathEnitySevice traversalLeafFile(String path, String searchExcuteImplName) throws IOException {
        this.path=path;
        return traversalLeafFile(searchExcuteImplName);
    }

    @Override
    public FilePathEnitySevice traversalLeafFile(String searchExcuteImplName) throws IOException {

        proxyExcute=ExcuteFactory.getPorduct(searchExcuteImplName);

        if(this.path.equals("")){

            File[] roots=File.listRoots();
            for(File file:roots){
                traversalLeafFileUnit(file);
            }

        }else{

            traversalLeafFileUnit(new File(this.path));

        }
        return this;
    }

    private void traversalLeafFileUnit(File file) throws IOException {
        if(file.isFile()){
            proxyExcute.Excute(file);
        }
        if(file.isDirectory()){
            File[] files=file.listFiles();
            if(files!=null && files.length<0){
                for(File fileUnit:files){
                    traversalLeafFileUnit(fileUnit);
                }
            }else {
                return;
            }
        }
    }





}
