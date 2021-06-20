package Service.systemlevel;

import enity.FilePathEnity;
import enity.PathConfigEnity;
import enity.PathUnitConfigEnity;

import java.io.IOException;
import java.util.Map;

/**
 * <p>用于release配置文件</p>
 * @author sangsong6th
 * @since 2021/5/27
 */
public interface FileConfigService {

    /**
     * <p>通过路径实体创建文件配置</p>
     * @param filePathEnity
     * @return
     * @throws IOException
     * @author sangsong6th
     * @since 2021/5/27
     */
    boolean createFileConfig(FilePathEnity filePathEnity) throws IOException;

    /**
     * <p>通过文件配置实体进行文件配置</p>
     * @param pathConfigEnity
     * @return
     * @throws IOException
     * @author sangsong6th
     * @since 2021/5/27
     */
    boolean createFileConfig(PathConfigEnity pathConfigEnity) throws IOException;


    boolean ishasFLP(String FilePath);



    boolean isEqualMd5(String FilePath,String Md5);



    boolean isOver(PathUnitConfigEnity pathUnitConfigEnity);


    boolean isNewAdd(PathConfigEnity pathConfigEnity,String path);

    boolean addNewOne(PathConfigEnity pathConfigEnity,String path) throws IOException;

    Map<String,PathUnitConfigEnity> whatNewAdd(PathConfigEnity pathConfigEnity);

    boolean addNewMap(PathConfigEnity pathConfigEnity,Map<String,PathUnitConfigEnity> pathUnitConfigEnityMap) throws IOException;
}
