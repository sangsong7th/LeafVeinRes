package impl;

import enity.FilePathEnity;
import inface.CreateFilePath;
import utill.FIleUnit;
import utill.StringUnit;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FirstCreatFilePath implements CreateFilePath {

    /**
     * <p>进行分类构建</p>
     * /A;B;C/1;2/C;B;D
     * @param classifyPath
     * @param classifyRoot
     * @return
     */
    @Override
    public boolean createFilePath(String classifyPath, String classifyRoot) {
        List<String> subClassify=StringUnit.stringSplit(classifyPath,"/");
        Stack<String> tempA=new Stack<>();
        Stack<String> tempB=new Stack<>();

        long flag=0;
        for(String subUnit:subClassify){
            List<String> overClassify=StringUnit.stringSplit(subUnit,";");
            if(tempA.size()==0||tempB.size()==0){
                if(flag==0){
                    for(String unit:overClassify){
                        tempA.push(""+unit);
                    }
                    flag=1;
                    continue;
                }
                if(flag==1){
                    while (!tempA.isEmpty()){
                        String before=tempA.pop();
                        for(String unit:overClassify){
                            tempB.push(before+"\\\\"+unit);
                        }
                    }
                    flag=2;
                    continue;
                }
                if(flag==2){
                    while (!tempB.isEmpty()){
                        String before=tempB.pop();
                        for(String unit:overClassify){
                            tempA.push(before+"\\\\"+unit);
                        }
                    }
                    flag=1;
                    continue;
                }
            }
        }

        if(flag==2){
            tempA=tempB;
        }

        while (!tempA.isEmpty()){
            String temp=classifyRoot+tempA.pop();
            FIleUnit.createDir(temp);
        }

        BFSFilePath bfsFilePath=new BFSFilePath();
        bfsFilePath.searchAllnoReturn(classifyRoot,"SearchExcuteForCreateFileConfig");

        return false;
    }
}
