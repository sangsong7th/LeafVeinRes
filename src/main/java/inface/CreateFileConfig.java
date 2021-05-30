package inface;

import enity.FilePathEnity;
import enity.PathConfigEnity;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * <p>用于生成路径配置文件</p>
 * @author sangsong6th
 * @since 2021/5/27
 */
public interface CreateFileConfig {

    /**
     * <p>通过路径实体创建文件配置</p>
     * @param filePathEnity
     * @return
     * @throws IOException
     */
    boolean createFileConfig(FilePathEnity filePathEnity) throws IOException;

    /**
     * <p>通过文件配置实体进行文件泪痣</p>
     * @param pathConfigEnity
     * @return
     * @throws IOException
     */
    boolean createFileConfig(PathConfigEnity pathConfigEnity) throws IOException;
}
