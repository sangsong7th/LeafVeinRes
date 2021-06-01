package impl.userlevel;

import impl.BFSFilePath;
import Service.systemlevel.FileTraversal;

/**
 *
 * @author sangsong6th
 * @since 2021/5/21
 * @version 1.0.0
 */
public class FileTraversalImpl implements FileTraversal {

    @Override
    public String FilePathCurrentList(String filePath) {

        BFSFilePath bfsFilePath=new BFSFilePath(filePath);
        return bfsFilePath.findPathlist().toString();
    }

}
