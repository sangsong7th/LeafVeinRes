package Service.excute.factory;

import Service.excute.ProxyExcute;
import impl.excute.factoryEnities.SearchExcuteForCreateFileConfig;


/**
 * <p>SearchExcute的工厂</p>
 * @author sangsong6th
 * @since 2021/5/27
 */

public class SearchExcuteFactory {

    public ProxyExcute getPorduct(String classname){

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
