package Service.excute.factory;

import impl.excute.factoryEnities.SearchExcuteForCreateFileConfig;
import Service.excute.SearchExcute;

/**
 * <p>SearchExcute的工厂</p>
 * @author sangsong6th
 * @since 2021/5/27
 */

public class SearchExcuteFactory {

    public SearchExcute getPorduct(String classname){

        switch (classname){
            case "SearchExcuteForCreateFileConfig":{
                return new SearchExcuteForCreateFileConfig();
            }
            case "SearchExcuteForCreateFileConfig2":{
                return new SearchExcuteForCreateFileConfig();
            }
        }

        return null;

    };

}
