package inface.excute;

import annotation.WillBeOptimized;
import enity.FilePathEnity;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>命令模式的运行单元</p>
 * @author sangsong6th
 * @since 2021/5/27
 */
@WillBeOptimized(value = "",action = "")
public interface SearchExcute {

    void Excute(FilePathEnity filePathEnity);

}
