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
    private String locationPath;

    /**
     *用来索引的hashcode
     */
    private String hashcode;


    public PathConfigEnity() {
        this.pathUnitConfigEnityList=null;
        this.locationPath="";
        this.hashcode="";
    }

    public List<PathUnitConfigEnity> getPathUnitConfigEnityList() {
        return pathUnitConfigEnityList;
    }

    public void setPathUnitConfigEnityList(List<PathUnitConfigEnity> pathUnitConfigEnityList) {
        this.pathUnitConfigEnityList = pathUnitConfigEnityList;
    }

    public String getLocationPath() {
        return locationPath;
    }

    public void setLocationPath(String locationPath) {
        this.locationPath = locationPath;
    }

    public String getHashcode() {
        return hashcode;
    }

    public void setHashcode(String hashcode) {
        this.hashcode = hashcode;
    }

    @Override
    public String toString() {
        return "PathConfigEnity{" +
                "pathUnitConfigEnityList=" + pathUnitConfigEnityList +
                ", locationPath='" + locationPath + '\'' +
                ", hashcode='" + hashcode + '\'' +
                '}';
    }
}
