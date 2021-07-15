package enity;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * <p>处理</p>
 * @author sangsong6th
 * @since 2021/2/15
 */
public class FilePathEnity {

    private String absolutePath;
    private FilePathEnity before;
    private List<FilePathEnity> files;

    /**
     * 1:是文件路径
     * 2:是文件
     * 4:是文件封装成软件形式的文件
     * 这样设计的目的是为了处理方便位运算
     */
    private long fileType;

    /**
     * 用于toString
     */
    private JSONObject result=new JSONObject();


    public FilePathEnity(String absolutePath, FilePathEnity before, List<FilePathEnity> files) {
        this.absolutePath = absolutePath;
        this.before = before;
        this.files = files;
    }

    public FilePathEnity(String absolutePath, FilePathEnity before, List<FilePathEnity> files, long fileType) {
        this.absolutePath = absolutePath;
        this.before = before;
        this.files = files;
        this.fileType = fileType;
    }

    public FilePathEnity(String absolutePath, FilePathEnity before, List<FilePathEnity> files, long fileType, JSONObject result) {
        this.absolutePath = absolutePath;
        this.before = before;
        this.files = files;
        this.fileType = fileType;
        this.result = result;
    }

    public String getAbsolutePath() {
        return absolutePath;
    }

    public void setAbsolutePath(String absolutePath) {
        this.absolutePath = absolutePath;
    }

    public FilePathEnity getBeforePath() {
        return before;
    }

    public void setBeforePath(FilePathEnity beforePath) {
        this.before = beforePath;
    }

    public List<FilePathEnity> getFiles() {
        return files;
    }

    public void setFiles(List<FilePathEnity> files) {
        this.files = files;
    }

    public FilePathEnity getBefore() {
        return before;
    }

    public void setBefore(FilePathEnity before) {
        this.before = before;
    }

    public long getFileType() {
        return fileType;
    }

    public void setFileType(long fileType) {
        this.fileType = fileType;
    }

    private void toStringDFS(FilePathEnity filePathEnity, JSONObject jsonObject){
        if(filePathEnity.files==null){
            jsonObject.put(filePathEnity.absolutePath,new JSONArray());
        }else{
            JSONArray jsonArray=new JSONArray();
            for(FilePathEnity filePathEnityTemp:filePathEnity.files){
                JSONObject jsonObjecttemp=new JSONObject();
                toStringDFS(filePathEnityTemp,jsonObjecttemp);
                jsonArray.add(jsonObjecttemp);
            }
            jsonObject.put(filePathEnity.absolutePath,jsonArray);
        }

    }

    @Override
    public String toString() {

        if(this.files==null){
            result.put(this.absolutePath,new JSONArray());
        }else{
            JSONArray jsonArray=new JSONArray();
            for(FilePathEnity filePathEnity:this.files){
                JSONObject jsonObjecttemp=new JSONObject();
                toStringDFS(filePathEnity,jsonObjecttemp);
                jsonArray.add(jsonObjecttemp);
            }
            result.put(this.absolutePath,jsonArray);
        }

        return result.toJSONString();
    }
}
