package com.ndms.ndms.passport.webapi.config;

import com.github.xiaoymin.knife4j.spring.extension.OpenApiExtensionResolver;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * Knife4j（Swagger2）的配置
 */
@Configuration
@EnableSwagger2WebMvc
@EqualsAndHashCode(callSuper = false)
public class Knife4jConfiguration {

    @Autowired
    private OpenApiExtensionResolver openApiExtensionResolver;

    @Bean(value = "ndms")
    public Docket ndms() {
        String groupName = "1.0.0";
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .host("http://www.ndms.com")
                .apiInfo(apiInfo())
                .groupName(groupName) //分组名称
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ndms.ndms.passport.webapi.controller")) //这里指定Controller扫描包路径
                .paths(PathSelectors.any())
                .build()
                .extensions(openApiExtensionResolver.buildExtensions(groupName));
        return docket;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("NDMS用戶登陸系統")
                .description("使用者查詢系統")
                .termsOfServiceUrl("http://www.ndms.com")
                .contact(new Contact("jsd@ndms.com", "http://jsd.ndms.comn", "jsd@ndms.com"))
                .version("1.0.0")
                .build();
    }

}
