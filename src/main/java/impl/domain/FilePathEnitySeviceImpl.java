package impl.domain;

import Service.domain.FilePathEnitySevice;
import Service.excute.ProxyExcute;
import Service.excute.factory.SearchExcuteFactory;
import enity.FilePathEnity;

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
