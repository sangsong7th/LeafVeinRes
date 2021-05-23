package impl.excute.factoryEnities;

import enity.FilePathEnity;
import impl.FirestCreatFileConfig;
import inface.CreateFileConfig;
import inface.excute.SearchExcute;

import java.io.IOException;

public class SearchExcuteForCreateFileConfig implements SearchExcute {

    @Override
    public void Excute(FilePathEnity filePathEnity) {

        CreateFileConfig firestCreatFileConfig=new FirestCreatFileConfig();

        try {
            firestCreatFileConfig.createFileConfig(filePathEnity);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
