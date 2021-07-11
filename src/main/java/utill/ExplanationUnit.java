package utill;

import annotation.WillBeOptimized;

import java.util.List;
import java.util.Stack;

/**
 * <p></p>
 */
public class ExplanationUnit {

    /**
     * <p>进行分类构建</p>
     * /A;B;C/1;2/C;B;D
     * @author sangsong6th
     * @since 2021/7/11
     * @param classifyPath
     * @return
     */
    private Stack<String> explanClassifyPath(String classifyPath) {

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

        return tempA;
    }

}
