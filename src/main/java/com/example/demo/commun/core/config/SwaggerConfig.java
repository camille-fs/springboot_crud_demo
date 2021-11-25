package com.example.demo.commun.core.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static java.util.Collections.emptyList;

@RequiredArgsConstructor
@EnableConfigurationProperties(SwaggerProperties.class)
@EnableSwagger2
@Configuration
public class SwaggerConfig {

    private final SwaggerProperties swaggerProperties;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(buildApiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo buildApiInfo() {
        return new ApiInfo(swaggerProperties.getTitle(), swaggerProperties.getDescription(),
                swaggerProperties.getVersion(), swaggerProperties.getTermsofserviceurl(), new Contact(
                "demoNameContact", "http://demourl", "demo@gmail.com"),
                swaggerProperties.getLicence(), swaggerProperties.getLicenceurl(), emptyList());
    }
}
