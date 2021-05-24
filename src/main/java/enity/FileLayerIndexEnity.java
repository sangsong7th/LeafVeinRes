package enity;

import java.util.List;

/**
 * <p>
 *     it is Entity that the layer of filePath
 * </p>
 * @author sangsong7th
 * @since 2021/3/2
 */
public class FileLayerIndexEnity {
    
    private FilePathEnity filePathEnity;
    private String Hashcode;
    private List<FilePathEnity> loactionfiles;


    public FilePathEnity getFilePathEnity() {
        return filePathEnity;
    }

    public void setFilePathEnity(FilePathEnity filePathEnity) {
        this.filePathEnity = filePathEnity;
    }

    public String getHashcode() {
        return Hashcode;
    }

    public void setHashcode(String hashcode) {
        Hashcode = hashcode;
    }

    public List<FilePathEnity> getLoactionfiles() {
        return loactionfiles;
    }

    public void setLoactionfiles(List<FilePathEnity> loactionfiles) {
        this.loactionfiles = loactionfiles;
    }

    @Override
    public String toString() {
        return "FileLayerIndexEnity{" +
                "filePathEnity=" + filePathEnity +
                ", Hashcode='" + Hashcode + '\'' +
                ", loactionfiles=" + loactionfiles +
                '}';
    }
}
