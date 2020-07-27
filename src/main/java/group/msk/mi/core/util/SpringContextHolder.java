package group.msk.mi.core.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Author 吕衡
 * @Create 2020/7/25 - 11:13
 * @Desc 从Spring上下文获取对象
 */
@Component
public class SpringContextHolder implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextHolder.applicationContext = applicationContext;
    }

    /**
     * 获取Spring上下文
     * @return
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 通过name从上下文中获取指定对象
     * @param name
     * @param <T>
     * @return
     * @throws BeansException
     */
    public static <T> T getBean(String name) throws BeansException {
        return (T) applicationContext.getBean(name);
    }

    /**
     * 通过类型获取对象
     * @param type
     * @param <T>
     * @return
     * @throws BeansException
     */
    public static <T> T getBean(Class<T> type)throws BeansException{
        return applicationContext.getBean(type);
    }
}
