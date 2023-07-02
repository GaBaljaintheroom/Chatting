package com.example.chatting.domain.chatMessage.controller;


import com.example.chatting.domain.chatMessage.dto.request.MessageCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class MessageController {

    @MessageMapping("/chat/enter/{roomId}")
    @SendTo("/sub/chat/room/{roomId}")
    public MessageCreateRequest enterUser(@DestinationVariable("roomId") String roomId, @Payload MessageCreateRequest message){
        return message;
    }
}
