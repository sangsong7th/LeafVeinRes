package connect.entity;

public class FileTraversalEnity {

    private String filePath;

    public FileTraversalEnity() {
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "FileTraversalEnity{" +
                "filePath='" + filePath + '\'' +
                '}';
    }
}
