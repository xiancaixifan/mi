package group.msk.mi.config;

import cn.hutool.core.util.ClassUtil;
import group.msk.mi.common.CommonLogFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


/**
 * @Author 吕衡
 * @Create 2020/7/24 - 17:31
 * @Desc Swagger配置类
 */
@Configuration
public class SwaggerConfig {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${swagger.contact.name}")
    String contactName;

    @Value("${swagger.contact.url}")
    String contactUrl;

    @Value("${swagger.contact.email}")
    String contactEmail;

    @Value("${swagger.title}")
    String title;

    @Value("${swagger.description}")
    String description;

    @Value("${swagger.version}")
    String version;

    @Value("${swagger.enabled}")
    boolean enabled;


    @Bean
    public Docket controllerApi(){
        logger.info(CommonLogFormat.START_LOADING_FORMAT, ClassUtil.getClassName(this.getClass(),false),"Swagger配置类");
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("group.msk.mi.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 站点描述信息
     * @return
     */
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .contact(new Contact(contactName,contactUrl,contactEmail))
                .version(version)
                .build();
    }
}
