package service.domain;

/**
 * <p>进行目录名称对于分类目录地址的映射</p>
 * @author sangsong6th
 * @since 2021/7/26
 */
public interface PathToCatalogueConfigService {
    /**
     * 通过名字和
     * @param name
     * @param path
     * @return
     */
    void buildConfig(String name,String path);
}
