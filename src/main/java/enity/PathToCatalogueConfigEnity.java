package enity;

import com.alibaba.fastjson.JSONObject;

/**
 * <p>用于分类目录名称对于分类目录地址的映射</p>
 * @author sangsong6th
 * @since 2021/7/26
 */
public class PathToCatalogueConfigEnity {
    private static volatile JSONObject jsonObject=new JSONObject();


    public static JSONObject getJsonObject() {
        return jsonObject;
    }

    public static void setJsonObject(JSONObject jsonObject) {
        PathToCatalogueConfigEnity.jsonObject = jsonObject;
    }

    @Override
    public String toString() {
        return jsonObject.toString();
    }

}
