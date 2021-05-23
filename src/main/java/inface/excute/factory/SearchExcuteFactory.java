package inface.excute.factory;

import impl.excute.factoryEnities.SearchExcuteForCreateFileConfig;
import inface.excute.SearchExcute;

public class SearchExcuteFactory {

    public SearchExcute getPorduct(String classname){

        switch (classname){
            case "SearchExcuteForCreateFileConfig":{
                return new SearchExcuteForCreateFileConfig();
            }
        }

        return null;

    };

}
