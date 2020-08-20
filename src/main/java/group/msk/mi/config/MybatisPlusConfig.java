package group.msk.mi.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author 吕衡
 * @Create 2020/8/19 - 19:59
 * @Desc TODO
 */
@Configuration
public class MybatisPlusConfig {

    /**
     * 设置分页
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor page = new PaginationInterceptor();
        // 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
        page.setOverflow(false);
        // 设置最大单页限制数量，默认 500 条，-1 不受限制
        page.setLimit(20);
        page.setDbType(DbType.MYSQL);
        //开启 count 的 join 优化,只针对部分 left join
        page.setCountSqlParser(new JsqlParserCountOptimize(true));
        return page;
    }
}