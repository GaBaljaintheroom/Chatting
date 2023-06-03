package com.example.chatting.global.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@OpenAPIDefinition(
        info = @Info(title = "채팅 서비스 API 명세서",
        description = "웹 소켓을 이용한 채팅 서비스 API 명세서",
        version = "v1"))
public class SwaggerConfig {


    @Bean
    public GroupedOpenApi chatOpenAPI() {
        String[] paths = {"{/api/v1/chat}"};

        return GroupedOpenApi.builder()
                .group("채팅 서비스 API v1")
                .pathsToMatch(paths)
                .build();
    }

}
