package Service.excute;

import annotation.WillBeOptimized;
import enity.FilePathEnity;

import java.io.IOException;

/**
 * <p>命令模式的运行单元</p>
 * @author sangsong6th
 * @since 2021/5/27
 */
@WillBeOptimized(contract = "sangsong6th",action = "",details = "",date="2021-05-01")
public interface ProxyExcute {

    void Excute(Object ...data) throws IOException;

}