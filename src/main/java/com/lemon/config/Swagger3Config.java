package com.lemon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


/**
 * @author ws
 * @date 2022/3/22 14:10
 * @blog https://lemonws.top
 * @github https://github.com/ws806416409
 */
@Configuration
public class Swagger3Config implements WebMvcConfigurer {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select() // 通过.select()方法，去配置扫描接口,RequestHandlerSelectors配置如何扫描接口
                /*
                basePackage(final String basePackage) // 根据包路径扫描接口
                any() // 扫描所有，项目中的所有接口都会被扫描到
                none() // 不扫描接口
                // 通过方法上的注解扫描，如withMethodAnnotation(GetMapping.class)只扫描get请求
                withMethodAnnotation(final Class<? extends Annotation> annotation)
                // 通过类上的注解扫描，如.withClassAnnotation(Controller.class)只扫描有controller注解的类中的接口
                withClassAnnotation(final Class<? extends Annotation> annotation)
                 */
                .apis(RequestHandlerSelectors.basePackage("com.lemon.controller"))// basePackage 根据包路径扫描接口
                /*
                any() // 任何请求都扫描
                none() // 任何请求都不扫描
                regex(final String pathRegex) // 通过正则表达式控制
                ant(final String antPattern) // 通过ant()控制
                 */
                .paths(PathSelectors.any())// 配置如何通过path过滤,即这里扫描所有请求 any none ant regex
                .build();
    }

    /**
     * API 页面上半部分展示信息
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger3接口文档")
                .description("文档描述")
                .contact(new Contact("lemon", "https://lemonws.top", "806416409@qq.com"))
                .version("1.0")
                .build();
    }

}
