package enity;

import java.util.List;

public class PathConfigEnity {

    private List<PathUnitConfigEnity> pathUnitConfigEnityList;

    /**
     * 物理地址
     */
    private String LocationPath;

    /**
     * 分类地址
     */
    private String ClassPath;

    /**
     * 虚拟分类地址
     */
    private String virClassPath;

    /**
     * 虚拟映射地址
     */
    private List<String> virClassPaths;

    private boolean bolnUpdataOver;

    private boolean bolnClassRoot;

    private boolean bolnDistributeDir;

    private List<String> DistributedDir;

    private boolean bolnVirPath;

    private boolean bolnMaster;

    private String masterDir;

    private List<String> slaveDir;

    private boolean bolnSlave;

    private String hashcode;

    public PathConfigEnity() {
    }

    public List<PathUnitConfigEnity> getPathUnitConfigEnityList() {
        return pathUnitConfigEnityList;
    }

    public void setPathUnitConfigEnityList(List<PathUnitConfigEnity> pathUnitConfigEnityList) {
        this.pathUnitConfigEnityList = pathUnitConfigEnityList;
    }

    public boolean isBolnUpdataOver() {
        return bolnUpdataOver;
    }

    public void setBolnUpdataOver(boolean bolnUpdataOver) {
        this.bolnUpdataOver = bolnUpdataOver;
    }

    public boolean isBolnClassRoot() {
        return bolnClassRoot;
    }

    public void setBolnClassRoot(boolean bolnClassRoot) {
        this.bolnClassRoot = bolnClassRoot;
    }

    public boolean isBolnDistributeDir() {
        return bolnDistributeDir;
    }

    public void setBolnDistributeDir(boolean bolnDistributeDir) {
        this.bolnDistributeDir = bolnDistributeDir;
    }

    public List<String> getDistributedDir() {
        return DistributedDir;
    }

    public void setDistributedDir(List<String> distributedDir) {
        DistributedDir = distributedDir;
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

    public List<String> getSlaveDir() {
        return slaveDir;
    }

    public void setSlaveDir(List<String> slaveDir) {
        this.slaveDir = slaveDir;
    }

    public boolean isBolnSlave() {
        return bolnSlave;
    }

    public void setBolnSlave(boolean bolnSlave) {
        this.bolnSlave = bolnSlave;
    }

    public String getHashcode() {
        return hashcode;
    }

    public void setHashcode(String hashcode) {
        this.hashcode = hashcode;
    }

    public String getLocationPath() {
        return LocationPath;
    }

    public void setLocationPath(String locationPath) {
        LocationPath = locationPath;
    }

    public String getClassPath() {
        return ClassPath;
    }

    public void setClassPath(String classPath) {
        ClassPath = classPath;
    }

    public String getVirClassPath() {
        return virClassPath;
    }

    public void setVirClassPath(String virClassPath) {
        this.virClassPath = virClassPath;
    }

    public List<String> getVirClassPaths() {
        return virClassPaths;
    }

    public void setVirClassPaths(List<String> virClassPaths) {
        this.virClassPaths = virClassPaths;
    }

    @Override
    public String toString() {
        return "PathConfigEnity{" +
                "pathUnitConfigEnityList=" + pathUnitConfigEnityList +
                ", LocationPath='" + LocationPath + '\'' +
                ", ClassPath='" + ClassPath + '\'' +
                ", virClassPath='" + virClassPath + '\'' +
                ", virClassPaths=" + virClassPaths +
                ", bolnUpdataOver=" + bolnUpdataOver +
                ", bolnClassRoot=" + bolnClassRoot +
                ", bolnDistributeDir=" + bolnDistributeDir +
                ", DistributedDir=" + DistributedDir +
                ", bolnVirPath=" + bolnVirPath +
                ", bolnMaster=" + bolnMaster +
                ", masterDir='" + masterDir + '\'' +
                ", slaveDir=" + slaveDir +
                ", bolnSlave=" + bolnSlave +
                ", hashcode='" + hashcode + '\'' +
                '}';
    }
}
