package mvc.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by zhuran on 2019/1/14 0014
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Aop {
    Class interceptor();
}
