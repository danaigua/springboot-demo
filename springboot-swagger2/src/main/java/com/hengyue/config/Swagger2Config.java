package com.hengyue.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    /**
     * 用于配置swagger2，包含文档基本信息
     * 指定swagger2的作用域（这里指定包路径下的所有API）
     * @return Docket
     */

    @Bean
    public Docket getDocketApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hengyue.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    /**
     * 构建文档基本信息，用于页面显示，可以包含版本、
     * 联系人信息、服务地址、文档描述信息等
     * @return ApiInfo
     */
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("我的第一个swagger项目")
                .description("团队成员可以通过localhost：10003/swagger-ui.html/   查看接口文档")
                .contact(new Contact("章家宝", "http://www.qiuzhisystem.com/", "1295263075@qq.com"))
                .version("1.0.0")
                .build();
    }
}
