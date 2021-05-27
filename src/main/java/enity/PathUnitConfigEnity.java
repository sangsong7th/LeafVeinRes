package enity;

/**
 * <p>文件配置文件或者是文件路径</p>
 * @author sangsong6th
 * @since 2021/5/24
 */
public class PathUnitConfigEnity {

    /*
    文件名字
     */
    private String name;
    /*
    当前地址
     */
    private String locationPath;
    /*
    真实文件存放地址
     */
    private String truePath;
    /*
    是否需要更新
     */
    private boolean bolnUpdata;
    /*
    文件大小单位字节
     */
    private Long size;
    /*
    文件完整性验证md5
     */
    private String md5;
    /*
    是否是一个文件夹
     */
    private boolean bolnDir;
    /*
    是否是虚拟地址
     */
    private boolean bolnVir;
    /*
    是否是可以扫描的地址
     */
    private boolean isScannerDir;

    public PathUnitConfigEnity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public boolean isBolnUpdata() {
        return bolnUpdata;
    }

    public void setBolnUpdata(boolean bolnUpdata) {
        this.bolnUpdata = bolnUpdata;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public boolean isBolnDir() {
        return bolnDir;
    }

    public void setBolnDir(boolean bolnDir) {
        this.bolnDir = bolnDir;
    }

    public boolean isBolnVir() {
        return bolnVir;
    }

    public void setBolnVir(boolean bolnVir) {
        this.bolnVir = bolnVir;
    }

    public boolean isScannerDir() {
        return isScannerDir;
    }

    public void setScannerDir(boolean scannerDir) {
        isScannerDir = scannerDir;
    }

    @Override
    public String toString() {
        return "PathUnitConfigEnity{" +
                "name='" + name + '\'' +
                ", locationPath='" + locationPath + '\'' +
                ", truePath='" + truePath + '\'' +
                ", bolnUpdata=" + bolnUpdata +
                ", size=" + size +
                ", md5='" + md5 + '\'' +
                ", bolnDir=" + bolnDir +
                ", bolnVir=" + bolnVir +
                ", isScannerDir=" + isScannerDir +
                '}';
    }
}
