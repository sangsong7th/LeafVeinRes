package inface;

import enity.FileLayerIndexEnity;

import java.util.List;

/**
 * 存储当前层级队列
 */
public interface FileLayerIndex {

    void pop(FileLayerIndexEnity fileLayerIndexEnity);

    void push(FileLayerIndexEnity fileLayerIndexEnity);

    void pop(FileLayerIndexEnity fileLayerIndexEnity, long index);

    long search(String key);

    void insert(FileLayerIndexEnity fileLayerIndexEnity, long index);

    void replace(List<FileLayerIndexEnity> fileLayerIndexEnityList, long index);

}
