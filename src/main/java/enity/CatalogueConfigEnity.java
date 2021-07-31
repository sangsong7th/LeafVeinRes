package enity;

import annotation.WillBeOptimized;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * <P>目录文件实体</P>
 * @author sangsong6th
 * @since  2021/7/19
 */
@WillBeOptimized(contract = "",action = "",details = "",date = "")
public class CatalogueConfigEnity {
    /**
     * 目录名称
     */
    private String catalogueName;
    /**
     * 本地目录
     */
    private String locationPath;
    /**
     * 文件目录分支
     */
    private String classifyJsonString;
    /**
    是否需要更新
     */
    private boolean bolnUpdata;

    /**
     *是否是分布式目录
     */
    private boolean bolnDistributeDir;
    /**
     *分布式目录列表
     */
    private List<String> distributedDir;
    /**
     *是否是虚拟路径
     */
    private boolean bolnVirPath;
    /**
     *是否是主路径
     */
    private boolean bolnMaster;
    /**
     *主路径
     */
    private String masterDir;
    /**
     *是否是从路径
     */
    private boolean bolnSlave;
    /**
     *从路径列表
     */
    private List<String> slaveDir;




    public CatalogueConfigEnity() {
        this.catalogueName = "";
        this.classifyJsonString = "";
        this.bolnUpdata = false;
        this.bolnDistributeDir=false;
        this.distributedDir = null;
        this.bolnMaster=false;
        this.masterDir="";
        this.bolnSlave=false;
        this.slaveDir=null;
    }

    public String getCatalogueName() {
        return catalogueName;
    }

    public void setCatalogueName(String catalogueName) {
        this.catalogueName = catalogueName;
    }

    public String getLocationPath() {
        return locationPath;
    }

    public void setLocationPath(String locationPath) {
        this.locationPath = locationPath;
    }

    public String getClassifyJsonString() {
        return classifyJsonString;
    }

    public void setClassifyJsonString(String classifyJsonString) {
        this.classifyJsonString = classifyJsonString;
    }

    public boolean isBolnUpdata() {
        return bolnUpdata;
    }

    public void setBolnUpdata(boolean bolnUpdata) {
        this.bolnUpdata = bolnUpdata;
    }

    public boolean isBolnDistributeDir() {
        return bolnDistributeDir;
    }

    public void setBolnDistributeDir(boolean bolnDistributeDir) {
        this.bolnDistributeDir = bolnDistributeDir;
    }

    public List<String> getDistributedDir() {
        return distributedDir;
    }

    public void setDistributedDir(List<String> distributedDir) {
        this.distributedDir = distributedDir;
    }

    public boolean isBolnVirPath() {
        return bolnVirPath;
    }

    public void setBolnVirPath(boolean bolnVirPath) {
        this.bolnVirPath = bolnVirPath;
    }

    public boolean isBolnMaster() {
        return bolnMaster;
    }

    public void setBolnMaster(boolean bolnMaster) {
        this.bolnMaster = bolnMaster;
    }

    public String getMasterDir() {
        return masterDir;
    }

    public void setMasterDir(String masterDir) {
        this.masterDir = masterDir;
    }

    public boolean isBolnSlave() {
        return bolnSlave;
    }

    public void setBolnSlave(boolean bolnSlave) {
        this.bolnSlave = bolnSlave;
    }

    public List<String> getSlaveDir() {
        return slaveDir;
    }

    public void setSlaveDir(List<String> slaveDir) {
        this.slaveDir = slaveDir;
    }

    @Override
    public String toString() {
        return "CatalogueConfigEnity{" +
                "catalogueName='" + catalogueName + '\'' +
                ", locationPath='" + locationPath + '\'' +
                ", classifyJsonString='" + classifyJsonString + '\'' +
                ", bolnUpdata=" + bolnUpdata +
                ", bolnDistributeDir=" + bolnDistributeDir +
                ", distributedDir=" + distributedDir +
                ", bolnVirPath=" + bolnVirPath +
                ", bolnMaster=" + bolnMaster +
                ", masterDir='" + masterDir + '\'' +
                ", bolnSlave=" + bolnSlave +
                ", slaveDir=" + slaveDir +
                '}';
    }
}
