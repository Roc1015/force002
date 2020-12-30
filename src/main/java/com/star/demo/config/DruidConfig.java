package com.star.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author WP
 * @date 2020/12/30  11:46
 */

@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.database")
    @Bean
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    //    后台监控
    @Bean
    public ServletRegistrationBean statViewServlet() {

        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet());

        HashMap<String,String> initParameters = new HashMap<>();

//          增加配置
        initParameters.put("loginUsername","admin");
        initParameters.put("loginPassword","123456");
//        允许谁可以访问
        initParameters.put("allow","");

        return bean;
    }

    //filter
    public FilterRegistrationBean webStatFilter(){

        FilterRegistrationBean bean = new FilterRegistrationBean();

        bean.setFilter(new WebStatFilter());

        Map<Object, Object> initParameters = new HashMap<>();

        initParameters.put("exclusions","*.js,*.css,/druid/*");
        bean.setInitParameters(initParameters);
        return bean;
    }
}
