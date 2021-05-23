package inface;

import enity.FilePathEnity;
import enity.PathConfigEnity;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface CreateFileConfig {

    boolean createFileConfig(FilePathEnity filePathEnity) throws IOException;

    boolean createFileConfig(PathConfigEnity pathConfigEnity) throws IOException;
}
