package com.ele.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

@Configuration
@OpenAPIDefinition(
        servers = @Server(url = "${server.servlet.context-path:}/")
)
@SecurityScheme(
        name = HttpHeaders.AUTHORIZATION,
        scheme = "Bearer",
        type = SecuritySchemeType.HTTP,
        in = SecuritySchemeIn.HEADER)
public class SwaggerConfig {
    @Bean
    GroupedOpenApi apis(
            @Value("${spring.application.name}") String appName) {
        return GroupedOpenApi.builder()
                .group(appName)
                .displayName(appName.toUpperCase())
                .packagesToScan("com.ele.controller")
                .addOpenApiCustomizer(openApi -> {
                    var info = new Info();
                    info.setTitle(appName.toUpperCase().replace("-", " "));
                    openApi.info(info);
                })
                .build();
    }

}

