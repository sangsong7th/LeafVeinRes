package impl.userlevel;

import impl.FirstCreatFilePath;
import inface.CreateFilePath;
import inface.userlevel.FIleBuild;

/**
 * @author sangsong6th
 * @since 2021/5/21
 * @version 1.0.0
 */
public class FileBuildImpl implements FIleBuild {

    @Override
    public boolean BuildClassPaths(String classifyStr, String classRoot) {
        CreateFilePath createFilePath=new FirstCreatFilePath();
        return createFilePath.createFilePath(classifyStr,classRoot);
    }

}
