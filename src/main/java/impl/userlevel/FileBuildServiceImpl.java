package impl.userlevel;

import impl.FirstCreatFilePath;
import Service.CreateFilePath;
import Service.userlevel.FileBuildService;

/**
 * @author sangsong6th
 * @since 2021/5/21
 * @version 1.0.0
 */
public class FileBuildServiceImpl implements FileBuildService {

    @Override
    public boolean BuildClassPaths(String classifyStr, String classRoot) {
        CreateFilePath createFilePath=new FirstCreatFilePath();
        return createFilePath.createFilePath(classifyStr,classRoot);
    }

}
