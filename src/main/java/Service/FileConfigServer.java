package Service;

import enity.PathConfigEnity;
import enity.PathUnitConfigEnity;

import java.io.IOException;
import java.util.Map;

public interface FileConfigServer {

    boolean ishasFLP(String FilePath);



    boolean isEqualMd5(String FilePath,String Md5);



    boolean isOver(PathUnitConfigEnity pathUnitConfigEnity);


    boolean isNewAdd(PathConfigEnity pathConfigEnity,String path);

    boolean addNewOne(PathConfigEnity pathConfigEnity,String path) throws IOException;

    Map<String,PathUnitConfigEnity> whatNewAdd(PathConfigEnity pathConfigEnity);

    boolean addNewMap(PathConfigEnity pathConfigEnity,Map<String,PathUnitConfigEnity> pathUnitConfigEnityMap) throws IOException;


    
}
