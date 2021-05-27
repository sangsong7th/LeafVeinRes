package enity;

import java.util.List;

/**
 * <p>文件路径的相关配置文件类</p>
 * @author sangsong6th
 * @since 2021/5/24
 */
public class PathConfigEnity {

    /**
     *文件配置文件列表
     */
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
     * 虚拟映射地址，也就是这个虚拟分类地址所有的文件地址
     */
    private List<String> virClassPaths;

    /**
     *是否是需要更新的文件路径
     */
    private boolean bolnUpdataOver;

    /**
     *是否是分类目录
     */
    private boolean bolnClassRoot;
    /**
     *是否是分布式目录
     */
    private boolean bolnDistributeDir;
    /**
     *分布式目录列表
     */
    private List<String> DistributedDir;
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
     *从路径列表
     */
    private List<String> slaveDir;
    /**
     *是否是从路径
     */
    private boolean bolnSlave;
    /**
     *用来索引的hashcode
     */
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
