package service.excute.factory;

import service.excute.ProxyExcute;
import impl.excute.factoryEnities.ExcuteForCreateFileConfig;


/**
 * <p>SearchExcute的工厂</p>
 * @author sangsong6th
 * @since 2021/5/27
 */

public class ExcuteFactory {

    public static ProxyExcute getPorduct(String classname){

        switch (classname){
            /*

             */
            case "ExcuteForCreateFileConfig":{
                return new ExcuteForCreateFileConfig();
            }
        }

        return null;

    };

}
