package com.wzd.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * 和spring连接数据库相关的配置类
 * @author wr847214947@163.com
 * @date 2020/6/23 15:39
 */
public class JdbcConfig {
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String user;
    @Value("${jdbc.password}")
    private String password;

    /**
     * 创建数据源对象
     */
    @Bean(name = "dataSource")
    public DataSource creatDateSource(){
            try{
                ComboPooledDataSource ds = new ComboPooledDataSource();
                ds.setDriverClass(driver);
                ds.setJdbcUrl(url);
                ds.setUser(user);
                ds.setPassword(password);
                return ds;
            }catch (Exception e){
                throw new RuntimeException(e);
            }
    }

}
