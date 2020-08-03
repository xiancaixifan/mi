package group.msk.mi.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author 吕衡
 * @Create 2020/7/31 - 19:18
 * @Desc 输出日志,请求,参数,返回值
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD})
public @interface WebLog {
    /**
     * 日志描述信息
     * @return
     */
    String description() default "";
}
