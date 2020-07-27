package group.msk.mi.core.util;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.util.Assert;

import java.util.Locale;

/**
 * @Author 吕衡
 * @Create 2020/7/25 - 11:06
 * @Desc 消息资源格式化工具,方便取MessageSource
 *
 */
public class MessageSourceUtil {
    private static MessageSource messageSource;

    static {
        messageSource = SpringContextHolder.getBean(MessageSource.class);
    }

    /**
     * 获取MessageSource中的消息
     * @param code
     * @param args 消息参数列表,用于 {0} {1} 这种占位消息
     * @param defaultMessage 无值时赋默认值
     * @param locale
     * @return
     */
    public static String getMessage(String code, Object[] args, String defaultMessage, Locale locale) {
        Assert.notNull(messageSource, "消息资源工具类未初始化到上下文");
        return messageSource.getMessage(code, args, defaultMessage, locale);
    }

    /**
     * 获取MessageSource中的消息
     * 无默认值情况,可能返回为null
     * @param code
     * @param args
     * @param locale
     * @return
     */
    public static String getMessage(String code, Object[] args, Locale locale) {
        Assert.notNull(messageSource, "消息资源工具类未初始化到上下文");
        try {
            return messageSource.getMessage(code, args, locale);
        } catch (NoSuchMessageException e) {
            //TODO 异常应进行日志说明,方便快速定位
            e.printStackTrace();
            return null;
        }
    }

    public static String getMessage(MessageSourceResolvable resolvable, Locale locale) {
        Assert.notNull(messageSource, "消息资源工具类未初始化到上下文");
        try {
            return messageSource.getMessage(resolvable, locale);
        } catch (NoSuchMessageException e) {
            e.printStackTrace();
            return null;
        }

    }

}