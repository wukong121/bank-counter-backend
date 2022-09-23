package com.mastercard.paymenttransfersystem.config.doc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPIConfig() {
        Info info = new Info();
        info
                .title("Intra Bank Payment Transfer System")
                .description("A new intra-bank payment transfer system to allow real time payments between internal accounts.")
                .version("v1.0.0");
        return new OpenAPI().info(info);
    }
}