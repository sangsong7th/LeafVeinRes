package impl.excute.factoryEnities;

import Service.systemlevel.FileConfigService;
import enity.FilePathEnity;
import Service.excute.SearchExcute;

import java.io.IOException;

public class SearchExcuteForCreateFileConfig implements SearchExcute {

    @Override
    public void Excute(FilePathEnity filePathEnity) {

        FileConfigService firestCreatFileConfig=new FirestCreatFileConfig();

        try {
            firestCreatFileConfig.createFileConfig(filePathEnity);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
