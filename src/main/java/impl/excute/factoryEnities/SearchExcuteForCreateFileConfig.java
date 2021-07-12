package impl.excute.factoryEnities;

import Service.excute.ProxyExcute;
import Service.systemlevel.FileConfigService;
import enity.FilePathEnity;
import impl.systemlevel.FileConfigServiceImpl;

import java.io.IOException;

public class SearchExcuteForCreateFileConfig implements ProxyExcute {

    private FileConfigService fileConfigService=new FileConfigServiceImpl();

    @Override
    public void Excute(Object ...args) throws IOException {

        if(args!=null && args.length!=0){
            if(args.length==1){
                if(args[0] instanceof FilePathEnity){
                    fileConfigService.createFileConfig(((FilePathEnity) args[0]));
                }
            }
        }else{
            /*
            这里运行无参的方法
             */
        }

    }

}
