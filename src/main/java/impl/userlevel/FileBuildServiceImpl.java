package impl.userlevel;

import impl.domain.CatalogueConfigServceImpl;
import impl.domain.PathToCatalogueCofigImpl;
import impl.systemlevel.FileConfigServiceImpl;
import service.domain.CatalogueConfigServce;
import service.domain.FilePathEnitySevice;
import service.domain.PathToCatalogueConfigService;
import service.userlevel.FileBuildService;
import impl.domain.FilePathEnitySeviceImpl;
import utill.ExplanationUnit;
import utill.FileUnit;
import service.systemlevel.FileConfigService;

import java.io.IOException;
import java.util.Stack;

/**
 * @author sangsong6th
 * @since 2021/5/21
 * @version 1.0.0
 */
public class FileBuildServiceImpl implements FileBuildService {
    
    private FilePathEnitySevice filePathEnitySevice=new FilePathEnitySeviceImpl();
    private FileConfigService fileConfigService=new FileConfigServiceImpl();
    private PathToCatalogueConfigService pathToCatalogueConfigService = new PathToCatalogueCofigImpl();
    private CatalogueConfigServce catalogueConfigServce=new CatalogueConfigServceImpl();

    @Override
    public boolean buildClassPaths(String classifyPath, String classifyRoot,String name) {

        pathToCatalogueConfigService.buildConfig(name,classifyRoot);
        Stack<String> relativeDirStack=ExplanationUnit.explanClassifyPath(classifyPath);
        for(String relativeDir:relativeDirStack){
            FileUnit.createDir(classifyRoot+relativeDir);
        }

        try {
            fileConfigService.createFileConfig(classifyRoot);
        } catch (IOException e) {
            e.printStackTrace();
        }
        catalogueConfigServce.buildConfig(name,classifyRoot);
        return true;
    }






    
}
