package com.example.demo.commun.core.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("swagger")
@Data
public class SwaggerProperties {
    private String title;
    private String description;
    private String version;
    private String termsofserviceurl;
    private String licence;
    private String licenceurl;

}
