package service.systemlevel;


/**
 * <p>用于release遍历查询用接口</p>
 * @author sangsong6th
 * @since 2021/4/26
 */
public interface FileTraversalService {

    /**
     * <p>返回当前目录位置</p>
     * @author sangsong6th
     * @since 2021/4/26
     * @param filePath
     * @return
     */
    String FilePathCurrentList(String filePath);

}
