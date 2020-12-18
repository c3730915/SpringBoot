package edu.jayden.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:jdbc.properties")
public class JdbcConfig {
    @Value("${jdbc.url}")
    String url;

    @Value("${jdbc.driver}")
    String driver;

    @Value("${jdbc.username}")
    String username;

    @Value("${jdbc.password}")
    String password;
    @Bean
    public DataSource dataSource(){
        /**
         * 注册数据源
         */
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUsername(username);
        dataSource.setUrl(url);
        dataSource.setPassword(password);
        return dataSource;
    }
}
