package enity;

public class PathUnitConfigEnity {
    private String name;
    private String locationPath;
    private String truePath;
    private boolean bolnUpdata;
    private Long size;
    private String md5;
    private boolean bolnDir;
    private boolean bolnVir;
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
