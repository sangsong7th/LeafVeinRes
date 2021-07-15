package Service.domain;

import enity.FilePathEnity;

import java.io.IOException;
import java.util.List;

/**
 * @author sangsong6th
 */
public interface FilePathEnitySevice {

    FilePathEnity findAll();

    FilePathEnity findAll(String path);

    FilePathEnity findCurrentPath(String path);

    FilePathEnity findCurrentPath();

    List<FilePathEnity> findLeafFile();

    List<FilePathEnity> findLeafFile(String path);

    FilePathEnitySevice traversalAllDir(String searchExcuteImplName) throws IOException;

    FilePathEnitySevice traversalAll(String path, String searchExcuteImplName) throws IOException;

    FilePathEnitySevice traversalAllDir(String path, String searchExcuteImplName) throws IOException;

    FilePathEnitySevice traversalAll(String searchExcuteImplName) throws IOException;

    FilePathEnitySevice traversalCurrentPath(String path,String searchExcuteImplName) throws IOException;

    FilePathEnitySevice traversalCurrentPath(String searchExcuteImplName) throws IOException;

    FilePathEnitySevice traversalLeafFile(String path,String searchExcuteImplName) throws IOException;

    FilePathEnitySevice traversalLeafFile(String searchExcuteImplName) throws IOException;


}
