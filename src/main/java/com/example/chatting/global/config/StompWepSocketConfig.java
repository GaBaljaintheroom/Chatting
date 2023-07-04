package com.example.chatting.global.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
public class StompWepSocketConfig implements WebSocketMessageBrokerConfigurer {

    //웹소켓 핸드셰이크 커넥션을 생성할 경로
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {

        registry.addEndpoint("/stomp/chat").setAllowedOrigins("*");
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {

        registry.setApplicationDestinationPrefixes("/pub");  //  @MessageMapping 메서드로 라우팅된다.  Client에서 SEND 요청을 처리
        registry.enableSimpleBroker("/sub");  // SimpleBroker는 해당하는 경로를 SUBSCRIBE하는 Client에게 메세지를 전달하는 간단한 작업을 수행
    }
}
