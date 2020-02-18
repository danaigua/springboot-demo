package com.hengyue.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DruidConfig {
    /**
     * 配置sql监控
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }

    /**
     * 注册一个StatViewServlet
     * @return
     */
    @Bean
    public ServletRegistrationBean<StatViewServlet> druidStatViewServlet() {
        ServletRegistrationBean<StatViewServlet> servletServletRegistrationBean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        /**
         * 添加初始化参数：initParams
         * 白名单
         */
        servletServletRegistrationBean.addInitParameter("allow", "127.0.0.1");
        /**
         * 黑名单
         *
         */
        servletServletRegistrationBean.addInitParameter("deny", "127.0.0.100");
        /**
         * 登录名称
         */
        servletServletRegistrationBean.addInitParameter("loginUsername", "root");
        /**
         * 登录密码
         */
        servletServletRegistrationBean.addInitParameter("loginPassword", "root");
        /**
         * 是否可以重置参数
         */
        servletServletRegistrationBean.addInitParameter("resetEnable", "false");
        return servletServletRegistrationBean;
    }
    /**
     * 配置过滤器
     *
     */
    @Bean
    public FilterRegistrationBean<WebStatFilter> setFilterFilterRegistrationBean(){
        FilterRegistrationBean<WebStatFilter> filterFilterRegistrationBean = new FilterRegistrationBean<WebStatFilter>();
        filterFilterRegistrationBean.setFilter(new WebStatFilter());
        filterFilterRegistrationBean.addUrlPatterns("/*");
        filterFilterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterFilterRegistrationBean;
    }
}
