package com.forum.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class Swagger2Config {
    @Value(value = "${spring.swagger.enabled}")
    private Boolean swaggerEnable;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(swaggerEnable)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.forum"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("自由者论坛接口文档")
                .description("spring boot swagger")
                .termsOfServiceUrl("http://localhost:5000/") // swagger 的url
                .version("1.1")
                .build();
    }
}
