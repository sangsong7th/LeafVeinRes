package impl.excute.factoryEnities;

import service.domain.FilePathEnitySevice;
import service.excute.ProxyExcute;
import service.systemlevel.FileConfigService;
import enity.FilePathEnity;
import impl.domain.FilePathEnitySeviceImpl;
import impl.systemlevel.FileConfigServiceImpl;

import java.io.File;
import java.io.IOException;

public class ExcuteForCreateFileConfig implements ProxyExcute {

    private FileConfigService fileConfigService=new FileConfigServiceImpl();
    private FilePathEnitySevice filePathEnitySevice=new FilePathEnitySeviceImpl();

    @Override
    public void Excute(Object ...args) throws IOException {

        if(args!=null && args.length>0){
            if(args.length==1){
                if(args[0] instanceof File){
                    FilePathEnity filePathEnity=filePathEnitySevice.findCurrentPath(((File)args[0]).getPath());
                    fileConfigService.createFileConfig(filePathEnity);
                }
            }
        }else{
            /*
            这里运行无参的方法
             */
        }

    }

}
