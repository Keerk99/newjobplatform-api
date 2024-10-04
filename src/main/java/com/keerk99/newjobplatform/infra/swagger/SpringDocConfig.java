package com.keerk99.newjobplatform.infra.swagger;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")))
                .info(new Info()
                        .title("New Job Platform API")
                        .version("1.0.0")
                        .description("Api for managing job listings, companies, and reviews")
                        .contact(new Contact()
                                .name("Keerk99")
                                .email("antonyhuamantuanama@gmail.com")
                        )
                );
    }
    @Bean
    public String message() {
        return  "Bearer is working";
    }
}
