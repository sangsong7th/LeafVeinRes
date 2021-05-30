package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/**
 * <p>标记需要处理</p>
 * @author sangsong6th
 * @since 2021/5/27
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface WillBeOptimized {
    String[] contract();
    String[] action();
    String[] details();
    String[] date();

}
