package Service.domain;

import enity.FilePathEnity;

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

    FilePathEnitySevice traversalAll(String path,String searchExcuteImplName);

    FilePathEnitySevice traversalAll(String searchExcuteImplName);

    FilePathEnitySevice traversalCurrentPath(String path,String searchExcuteImplName);

    FilePathEnitySevice traversalCurrentPath(String searchExcuteImplName);

    FilePathEnitySevice traversalLeafFile(String path,String searchExcuteImplName);

    FilePathEnitySevice traversalLeafFile(String searchExcuteImplName);


}
