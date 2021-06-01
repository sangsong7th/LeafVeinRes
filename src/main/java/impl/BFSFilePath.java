package impl;

import enity.FilePathEnity;
import Service.FindFilePath;
import Service.excute.SearchExcute;
import Service.excute.factory.SearchExcuteFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BFSFilePath implements FindFilePath {

    private String path;

    private FilePathEnity data;

    private static boolean limit=false;

    private static long isALL=0;

    private SearchExcute searchExcute;

    /**
     * 初始化，获取存储设备工具
     */
    public BFSFilePath(){

        this.path="";


    }

    public BFSFilePath(String path){
        this.path=path;
    }


    @Override
    public FilePathEnity findAll() {

        if(this.path.equals("")){

            File[] roots=File.listRoots();
            List<FilePathEnity> filePathEnities=new ArrayList<FilePathEnity>();
            for(File file:roots){
                List<FilePathEnity> filePathEnitiestemp=new ArrayList<FilePathEnity>();

                long isFile=1;
                if(file.isDirectory()){
                    isFile=0;
                }

                filePathEnitiestemp=findFilePathEnity(file.getPath());

                FilePathEnity filePathEnitytemp=new FilePathEnity(file.getPath(),null,filePathEnitiestemp,isFile);

                filePathEnities.add(filePathEnitytemp);
            }
            FilePathEnity filePathEnity=new FilePathEnity(this.path,null,filePathEnities,0);
            return filePathEnity;
        }else{

            File dir=new File(this.path);
            File[] files=dir.listFiles();
            List<FilePathEnity> filePathEnities=new ArrayList<FilePathEnity>();
            if(files!=null) {
                for (File file : files) {
                    List<FilePathEnity> filePathEnitiestemp = new ArrayList<FilePathEnity>();
                    long isFile = 1;
                    if (file.isDirectory()) {
                        isFile = 0;
                    }
                    filePathEnitiestemp = findFilePathEnity(file.getPath());
                    FilePathEnity filePathEnitytemp = new FilePathEnity(file.getPath(), null, filePathEnitiestemp, isFile);
                    filePathEnities.add(filePathEnitytemp);
                }
            }
            FilePathEnity filePathEnity=new FilePathEnity(this.path,null,filePathEnities);
            return filePathEnity;

        }
    }

    private List<FilePathEnity> findFilePathEnity(String path){
        File dir=new File(path);
        if(dir.isDirectory()){
            File[] fileTemps=dir.listFiles();
            List<FilePathEnity> filePathEnities=new ArrayList<FilePathEnity>();
            if(fileTemps!=null&&fileTemps.length>0){

                for(File file:fileTemps){
                    List<FilePathEnity> filePathEnitiestemp=new ArrayList<FilePathEnity>();
                    filePathEnitiestemp=findFilePathEnity(file.getPath());
                    FilePathEnity filePathEnity=new FilePathEnity(file.getPath(),null,filePathEnitiestemp);
                    filePathEnities.add(filePathEnity);
                }
                return filePathEnities;

            }else {
                return null;
            }

        }else{
            return null;
        }


    }

    public FilePathEnity findPathlist(){

        if(this.path.equals("")){
            File[] roots=File.listRoots();
            List<FilePathEnity> filePathEnities=new ArrayList<FilePathEnity>();
            for(File file:roots){
                FilePathEnity filePathEnitytemp=new FilePathEnity(file.getPath(),null,null,file.isFile()?1:0);
                filePathEnities.add(filePathEnitytemp);
            }
            FilePathEnity filePathEnity=new FilePathEnity(this.path,null,filePathEnities,0);
            return filePathEnity;
        }else{

            File dir=new File(this.path);
            File[] files=dir.listFiles();
            List<FilePathEnity> filePathEnities=new ArrayList<FilePathEnity>();
            for(File file:files) {
                FilePathEnity filePathEnitytemp = new FilePathEnity(file.getPath(), null, null, file.isFile()?1:0);
                filePathEnities.add(filePathEnitytemp);
            }
            FilePathEnity filePathEnity=new FilePathEnity(this.path,null,filePathEnities,0);
            return filePathEnity;

        }

    }

    public void searchAllnoReturn(String path,String searchExcuteImplName){
        SearchExcuteFactory searchExcuteFactory=new SearchExcuteFactory();
        searchExcute=searchExcuteFactory.getPorduct(searchExcuteImplName);

        if(path.equals("")){

            File[] roots=File.listRoots();
            for(File file:roots){
                searchAllnoReturn(file.getPath());
            }

        }else{

            searchAllnoReturn(path);

        }
    }

    private void searchAllnoReturn(String path){

        if(searchExcute==null){
            return;
        }

        File dir=new File(path);

        File[] files=dir.listFiles();

        this.path=path;

        FilePathEnity filePathEnity=findPathlist();
        searchExcute.Excute(filePathEnity);

        if(dir.isFile()){
            return;
        }

        if(files==null || files.length==0){

            return;

        }else {

            for(File file:files){
                searchAllnoReturn(file.getPath());
            }

        }

    }

    @Override
    public FilePathEnity findAll(String path) {
        return null;
    }



    @Override
    public void getAllForJSONFile() {

    }

    @Override
    public void getAllforStringFile() {

    }



}
