package service.userlevel;

import java.util.List;
import java.util.Map;

/**
 * <p>用来release构建新的文件相关东西的接口</p>
 * @author sangsogn6th
 * @since 2021/5/30
 */
public interface FileBuildService {

    boolean buildClassPaths(String classifyStr,String classRoot,String name);

}
