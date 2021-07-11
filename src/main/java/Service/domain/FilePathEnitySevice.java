package Service.domain;

import enity.FilePathEnity;

import java.util.List;

/**
 * @author sangsong6th
 */
public interface FilePathEnitySevice {

    FilePathEnity findAll();

    FilePathEnity findAll(String path);

    List<FilePathEnity> findCurrentPath(String path);

    List<FilePathEnity> findCurrentPath();
}
