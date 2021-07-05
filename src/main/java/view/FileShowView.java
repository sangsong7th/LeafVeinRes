package view;

import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;

/**
 *
 */
public class FileShowView {

    /**
     * 唯一性id
     */
    private String id;
    /**
     *文件名称
     */
    private String fileName;
    /**
     *当地地址
     */
    private String locationPath;
    /**
     *物理地址
     */
    private String truePath;
    /**
     *主地址
     */
    private String masterPath;
    /**
     *文件大小
     */
    private String size;
    /**
     * 文件类型
     */
    private String fileType;
    /**
     * 从地址
     */
    private List<String> slavePath;
    /**
     * 备份地址
     */
    private List<String> backupPath;
    /**
     * 标签显示
     * {
     *     isScannerDir是否是可以扫描的目录
     *     bolnUpdata是否是需要更新的目录
     *     分类类型
     * }
     */
    private Map<String,String> mark;
    /**
     * 图标地址
     */
    private String iconpath;


    public FileShowView() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getTruePath() {
        return truePath;
    }

    public void setTruePath(String truePath) {
        this.truePath = truePath;
    }

    public String getMasterPath() {
        return masterPath;
    }

    public void setMasterPath(String masterPath) {
        this.masterPath = masterPath;
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

    public List<String> getSlavePath() {
        return slavePath;
    }

    public void setSlavePath(List<String> slavePath) {
        this.slavePath = slavePath;
    }

    public List<String> getBackupPath() {
        return backupPath;
    }

    public void setBackupPath(List<String> backupPath) {
        this.backupPath = backupPath;
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
