package impl.domain;

import com.alibaba.fastjson.JSONObject;
import enity.CatalogueConfigEnity;
import service.domain.CatalogueConfigServce;
import service.domain.FilePathEnitySevice;
import utill.FileUnit;

public class CatalogueConfigServceImpl implements CatalogueConfigServce {

    private CatalogueConfigEnity catalogueConfigEnity=new CatalogueConfigEnity();

    @Override
    public void buildConfig(String name, String path) {

        catalogueConfigEnity.setCatalogueName(name);
        catalogueConfigEnity.setLocationPath(path);
        FilePathEnitySevice filePathEnitySevice=new FilePathEnitySeviceImpl();

        catalogueConfigEnity.setClassifyJsonString(
                filePathEnitySevice.findAll(path).toStringDir()
        );

        FileUnit.outputJSONString(JSONObject.toJSONString(catalogueConfigEnity),path+"\\"+name+".CLGE");

    }

}
