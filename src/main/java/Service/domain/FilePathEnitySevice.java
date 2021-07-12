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

    FilePathEnitySevice traversalAll(String path,String searchExcuteImplName);

    FilePathEnitySevice traversalAll(String searchExcuteImplName);

}
