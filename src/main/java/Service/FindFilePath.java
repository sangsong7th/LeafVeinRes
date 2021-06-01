package Service;

import enity.FilePathEnity;

/**
 * 遍历树状结构
 */
public interface FindFilePath<T> {

    FilePathEnity findAll();
    FilePathEnity findAll(String path);


    void getAllForJSONFile();
    void getAllforStringFile();



}
