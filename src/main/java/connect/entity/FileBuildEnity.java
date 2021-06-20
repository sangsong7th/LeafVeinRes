package connect.entity;

public class FileBuildEnity {
    private String classifyStr;
    private String classRoot;

    public FileBuildEnity() {
    }

    public String getClassifyStr() {
        return classifyStr;
    }

    public void setClassifyStr(String classifyStr) {
        this.classifyStr = classifyStr;
    }

    public String getClassRoot() {
        return classRoot;
    }

    public void setClassRoot(String classRoot) {
        this.classRoot = classRoot;
    }

    @Override
    public String toString() {
        return "FileBuildEnity{" +
                "classifyStr='" + classifyStr + '\'' +
                ", classRoot='" + classRoot + '\'' +
                '}';
    }
}
