package impl.excute.factoryEnities;

import Service.systemlevel.FileConfigService;
import enity.FilePathEnity;
import Service.excute.SearchExcute;
import impl.systemlevel.FileConfigServiceImpl;

import java.io.IOException;

public class SearchExcuteForCreateFileConfig implements SearchExcute {

    @Override
    public void Excute(FilePathEnity filePathEnity) {

        FileConfigService fileConfigService=new FileConfigServiceImpl();

        try {
            fileConfigService.createFileConfig(filePathEnity);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
