package impl.domain;

import Service.domain.FilePathEnitySevice;
import Service.excute.SearchExcute;
import Service.excute.factory.SearchExcuteFactory;
import enity.FilePathEnity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FilePathEnitySeviceImpl implements FilePathEnitySevice {

    private String path;

    private SearchExcute searchExcute;

    /**
     * 初始化，获取存储设备工具
     */
    public FilePathEnitySeviceImpl(){

        this.path="";


    }

    public FilePathEnitySeviceImpl(String path){
        this.path=path;
    }


    @Override
    public FilePathEnity findAll() {

        return null;

    }

    @Override
    public FilePathEnity findAll(String path) {

        return null;
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
    public FilePathEnitySevice traversalAll(String path,String searchExcuteImplName) {
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
        return null;
    }

    private void searchAllnoReturn(String path){

        if(searchExcute==null){
            return;
        }

        File dir=new File(path);

        File[] files=dir.listFiles();

        this.path=path;

        FilePathEnity filePathEnity=findCurrentPath();
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
    public FilePathEnitySevice traversalAll(String path) {
        return null;
    }









}
