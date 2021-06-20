package Service;

import enity.FilePathEnity;

import java.util.List;

/**
 * 遍历树状结构
 */
public interface FindFilePath<T> {

    FilePathEnity findAll();

    FilePathEnity findAll(String path);

    List<FilePathEnity> findCurrentPath(String path);

    List<FilePathEnity> findCurrentPath();


}
