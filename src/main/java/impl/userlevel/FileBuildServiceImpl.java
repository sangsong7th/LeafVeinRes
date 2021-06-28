package impl.userlevel;

import annotation.WillBeOptimized;
import impl.BFSFilePath;
import Service.userlevel.FileBuildService;
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
    
    private BFSFilePath bfsFilePath = new BFSFilePath();


    @Override
    public boolean buildClassPaths(String classifyPath, String classifyRoot) {
        
        buidDClassPathsForSingle(classifyPath,classifyRoot);
        /*
       通过分类的根目录文件进行config建立
         */
        bfsFilePath.searchAllnoReturn(classifyRoot, "SearchExcuteForCreateFileConfig");

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

    /**
     * <p>进行分类构建</p>
     * /A;B;C/1;2/C;B;D
     *
     * @param classifyPath
     * @param classifyRoot
     * @return
     */
    private boolean buidDClassPathsForSingle(String classifyPath, String classifyRoot) {
        List<String> subClassify = StringUnit.stringSplit(classifyPath, "/");
        Stack<String> tempA = new Stack<>();
        Stack<String> tempB = new Stack<>();
        /*
         * 解析字符串遍历目录成list
         */
        @WillBeOptimized(action = "chonggou", contract = "", details = "", date = "")
        long flag = 0;
        for (String subUnit : subClassify) {

            List<String> overClassify = StringUnit.stringSplit(subUnit, ";");
            if (tempA.size() == 0 || tempB.size() == 0) {

                if (flag == 0) {
                    for (String unit : overClassify) {
                        tempA.push("" + unit);
                    }
                    flag = 1;
                    continue;
                }

                if (flag == 1) {
                    while (!tempA.isEmpty()) {
                        String before = tempA.pop();
                        for (String unit : overClassify) {
                            tempB.push(before + "\\\\" + unit);
                        }
                    }
                    flag = 2;
                    continue;
                }

                if (flag == 2) {
                    while (!tempB.isEmpty()) {
                        String before = tempB.pop();
                        for (String unit : overClassify) {
                            tempA.push(before + "\\\\" + unit);
                        }
                    }
                    flag = 1;
                    continue;
                }
            }
        }

        if (flag == 2) {
            tempA = tempB;
        }

        while (!tempA.isEmpty()) {
            String temp = classifyRoot + tempA.pop();
            FIleUnit.createDir(temp);
        }
        
        return true;
    }


    
}
