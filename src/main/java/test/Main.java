package test;

import Service.domain.FilePathEnitySevice;
import Service.userlevel.FileBuildService;
import enity.FilePathEnity;
import impl.domain.FilePathEnitySeviceImpl;
import impl.userlevel.FileBuildServiceImpl;
import utill.FIleUnit;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileBuildService fileBuildService=new FileBuildServiceImpl();
        /**
         * list 添加
         */
        /**
         * 单个添加
         */
//        fileBuildService.BuildClassPaths("/文字;图片;视频;混合;声音/","E:\\媒体");

//
//        BFSFilePath findFilePath=new BFSFilePath("D:\\testspace\\cxttpc\\service_content");
//        FilePathEnity filePathEnity=findFilePath.findPathlist();
//        CreateFileConfig createFileConfig=new FirestCreatFileConfig();
//        createFileConfig.createFileConfig(filePathEnity);

//        CreateFilePath createFilePath=new FirstCreatFilePath();
//        createFilePath.createFilePath("/A;B;C/1;2/C;B;D","D:\\testspace");

            //初始化配置文件
//            BFSFilePath bfsFilePath=new BFSFilePath();
//            bfsFilePath.searchAllnoReturn("D:\\testspace\\A","SearchExcuteForCreateFileConfig");


        FilePathEnitySevice filePathEnitySevice=new FilePathEnitySeviceImpl();

        FilePathEnity filePathEnity=filePathEnitySevice.findAll(null);

        /**
            //遍历更新配置文件
                //判断是否存在配置文件
                //判断配置文件是否和文件配置相符
                //判断配置的不相符文件条目是否为未同步完毕的文件
                //判断是否有新添加的文件
                //修改文件 返回修改的所有文件 路径 文件名 大小变化 返回总容量
            //添加 修改 禁止访问文件
                //修改为禁止访问文件 并删除路径下全部文件
                //添加为禁止访问文件 并添加所有路径

            //添加 分类目录
                //检查是否存在
                //同时添加

            //通过字串添加分类目录
                //检查是否存在
                //进行添加

            //list添加分类目录
                //检查是否存在
                //进行添加

            //文件路径list添加分类文件
                //首先先更新配置文件 并将同步标识设置为false
                //然后开始顺次复制文件 同时检查原文件状态
                //之后
            //复制文件

            //分布式路径
         **/






    }
}
