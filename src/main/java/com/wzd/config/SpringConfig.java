package com.wzd.config;

import com.sun.tracing.dtrace.ProviderAttributes;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

/**
 * @author wr847214947@163.com
 * @date 2020/6/23 15:48
 */
@ComponentScan(basePackages = {"com.wzd"})
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbc.properties")
public class SpringConfig {

    /**
     * 用于创建一个QueryRunner对象
     */
    @Bean(name="runner")
    @Scope("prototype")
    public QueryRunner creatQueryRunner(DataSource dataSource){
        return new QueryRunner(dataSource);
    }

}
