package group.msk.mi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.ConfigurableEnvironment;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi //开启Swagger3
public class MiApplication {
    private static Logger  logger = LoggerFactory.getLogger(MiApplication.class);

    public static void main(String[] args) {
        ConfigurableEnvironment environment = SpringApplication.run(MiApplication.class, args).getEnvironment();
        String port = environment.getProperty("server.port");
        logger.info("\nAccess Url:\n\t------------------------------------\n\t" +
                "Local  :\thttp://127.0.0.1:{}\n\t" +
                "Swagger:\thttp://127.0.0.1:{}/swagger-ui/index.html\n\t"+
                "------------------------------------\n\t",port,port);
    }

}
