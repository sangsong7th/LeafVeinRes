package impl.domain;

import com.alibaba.fastjson.JSONObject;
import enity.PathToCatalogueConfigEnity;
import service.domain.PathToCatalogueConfigService;
import utill.FileUnit;

/**
 *
 */
public class PathToCatalogueCofigImpl implements PathToCatalogueConfigService {
    @Override
    public void buildConfig(String name, String path) {
        JSONObject jsonObject=PathToCatalogueConfigEnity.getJsonObject();
        jsonObject.put(name,path);
        FileUnit.createDir(path);
        FileUnit.outputJSONString(jsonObject.toJSONString(),"config.catalogue");
    }
}
