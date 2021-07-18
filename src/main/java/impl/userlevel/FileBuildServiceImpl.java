package impl.userlevel;

import impl.systemlevel.FileConfigServiceImpl;
import service.domain.FilePathEnitySevice;
import service.userlevel.FileBuildService;
import impl.domain.FilePathEnitySeviceImpl;
import utill.ExplanationUnit;
import utill.FIleUnit;
import service.systemlevel.FileConfigService;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @author sangsong6th
 * @since 2021/5/21
 * @version 1.0.0
 */
public class FileBuildServiceImpl implements FileBuildService {
    
    private FilePathEnitySevice filePathEnitySevice=new FilePathEnitySeviceImpl();
    private FileConfigService fileConfigService=new FileConfigServiceImpl();

    @Override
    public boolean buildClassPaths(String classifyPath, String classifyRoot) {

        Stack<String> relativeDirStack=ExplanationUnit.explanClassifyPath(classifyPath);
        for(String relativeDir:relativeDirStack){
            FIleUnit.createDir(classifyRoot+relativeDir);
        }

        try {
            fileConfigService.createFileConfig(classifyRoot);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean buildClassPaths(Map<String, String> classifyStrAndRoots) {

        for(String key: classifyStrAndRoots.keySet()){
            buildClassPaths(key,classifyStrAndRoots.get(key));
        }
        return false;
    }

    @Override
    public boolean buildClassPaths(List<String> classifyStrs, String classRoot) {

        for(String unit:classifyStrs){
            buildClassPaths(unit,classRoot);
        }
        return false;
    }

    @Override
    public boolean buildClassPaths(String classifyStr, List<String> classRoots) {
        for(String unit:classRoots){
            buildClassPaths(classifyStr,unit);
        }
        return false;
    }




    
}
