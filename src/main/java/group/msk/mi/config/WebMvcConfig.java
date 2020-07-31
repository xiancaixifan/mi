package group.msk.mi.config;

import cn.hutool.core.util.ClassUtil;
import group.msk.mi.common.CommonLogFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.Charset;
import java.util.List;

/**
 * @Author 吕衡
 * @Create 2020/7/25 - 09:44
 * @Desc 请求适配器, 用于过滤和映射服务请求
 */

//@Configuration 还不懂是啥意思,懂了再用,不懂不用
public class WebMvcConfig extends WebMvcConfigurationSupport {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 建议使用该方法进行HttpMessageConverters的修改，此时的converters已经是Spring初始化过的
     * 因为加入了WebMvcConfigure，导致Spring的HttpMessageConverters中的String转换类默认使用ISO-8859-1编码
     * 所以这里对Spring已经初始化过的StringHttpMessageConverter的编码进行修改
     *
     * 最终效果是保证所有请求输出的对象格式都为UTF-8 若前端显示乱码,则是前端编码格式的问题了
     * @param converters
     */
    @Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        logger.info(CommonLogFormat.START_LOADING_FORMAT, ClassUtil.getClassName(this.getClass(),false),"请求映射配置类");
        converters.forEach(converter -> {
            if (converter instanceof StringHttpMessageConverter){
                ((StringHttpMessageConverter) converter).setDefaultCharset(Charset.forName("UTF-8"));
            }
        });
    }

    /**
     * 发现如果继承了WebMvcConfigurationSupport，则在yml中配置的相关内容会失效。 需要重新指定静态资源
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
    }
}
