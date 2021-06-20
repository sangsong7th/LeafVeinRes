package Service.userlevel;

import vo.FileListShowVo;

import java.util.List;

/**
 * <p>用于用户级别的展示文件的信息的接口</p>
 * @author sangsong6th
 * @since 2021/4/26
 */
public interface FileShowInfService {

    /**
     * <p>通过CurrentPath获取CurrentPath的FileList</p>
     * @author sangsong6th
     * @since 2021/4/26
     * @param FilePath
     * @return FileListShowVo
     */
    List<FileListShowVo> getFileListShowForCurrentPathByCurrentPath(String FilePath);
}
