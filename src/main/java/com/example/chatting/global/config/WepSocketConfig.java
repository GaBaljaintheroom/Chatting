package com.example.chatting.global.config;

import com.example.chatting.domain.chatMessage.service.WebSocketHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocket
public class WepSocketConfig implements WebSocketMessageBrokerConfigurer {

    // example는 WebSocket 또는 SockJS Client가 웹소켓 핸드셰이크 커넥션을 생성할 경로
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {

        registry.addEndpoint("/example").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {

        config.setApplicationDestinationPrefixes("/test");  //  @MessageMapping 메서드로 라우팅된다.
        config.enableSimpleBroker("/topic", "/queue");  //  메세지를 브로커로 라우팅한다.
    }
}
