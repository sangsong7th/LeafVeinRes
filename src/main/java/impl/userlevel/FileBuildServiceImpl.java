package impl.userlevel;

import Service.domain.FilePathEnitySevice;
import annotation.WillBeOptimized;
import Service.userlevel.FileBuildService;
import impl.domain.FilePathEnitySeviceImpl;
import utill.FIleUnit;
import utill.StringUnit;

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


    @Override
    public boolean buildClassPaths(String classifyPath, String classifyRoot) {


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
