package vo;

import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;

/**
 *
 */
public class FileListShowVo {

    private String fileName;
    private String locationPath;
    private String classesPath;
    private String size;
    private String fileType;
    private List<String> classeType;
    private Map<String,String> mark;
    private String iconpath;

    public FileListShowVo() {
    }

    public FileListShowVo(String fileName, String locationPath, String classesPath, String size, String fileType, List<String> classeType, Map<String, String> mark, String iconpath) {
        this.fileName = fileName;
        this.locationPath = locationPath;
        this.classesPath = classesPath;
        this.size = size;
        this.fileType = fileType;
        this.classeType = classeType;
        this.mark = mark;
        this.iconpath = iconpath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getLocationPath() {
        return locationPath;
    }

    public void setLocationPath(String locationPath) {
        this.locationPath = locationPath;
    }

    public String getClassesPath() {
        return classesPath;
    }

    public void setClassesPath(String classesPath) {
        this.classesPath = classesPath;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public List<String> getClasseType() {
        return classeType;
    }

    public void setClasseType(List<String> classeType) {
        this.classeType = classeType;
    }

    public Map<String, String> getMark() {
        return mark;
    }

    public void setMark(Map<String, String> mark) {
        this.mark = mark;
    }

    public String getIconpath() {
        return iconpath;
    }

    public void setIconpath(String iconpath) {
        this.iconpath = iconpath;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
