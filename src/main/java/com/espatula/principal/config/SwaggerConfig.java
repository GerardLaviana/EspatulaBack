package com.espatula.principal.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig implements WebMvcConfigurer {

	@Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.apiInfo(getApiInfo())
        		.securityContexts(Arrays.asList(securityContext()))
                .securitySchemes(Arrays.asList(apiKey()))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.espatula.principal"))
                .paths(PathSelectors.any())
                .build();
    }

	private ApiKey apiKey(){
        return new ApiKey("JWT", "Authorization", "header");
    }

    private SecurityContext securityContext(){
        return SecurityContext.builder().securityReferences(defaultAuth()).build();
    }

    private List<SecurityReference> defaultAuth(){
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
    }
	
    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "Recetas Service API",
                "Recetas Service API Description",
                "1.0",
                "http://localhost:8095",
                new Contact("Gerard Gamonal", "https://localhost:8095", "gerard@admin.com"),
                "LICENSE",
                "LICENSE URL",
                Collections.emptyList()
        );
    }
}
