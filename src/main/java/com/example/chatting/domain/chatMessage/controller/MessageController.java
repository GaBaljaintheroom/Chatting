package com.example.chatting.domain.chatMessage.controller;


import com.example.chatting.domain.chatMessage.dto.MessageInfo;
import com.example.chatting.domain.chatMessage.dto.request.MessageCreateRequest;
import com.example.chatting.domain.chatMessage.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    // 채팅방 입장
    @MessageMapping("/chat/enter/{roomId}")
    @SendTo("/sub/chat/room/{roomId}")
    public MessageInfo enterUser(@DestinationVariable("roomId") Long roomId, @Payload MessageCreateRequest message){
        message.setMessage(message.getSender() + "님이 채팅방에 입장하였습니다.");
        return messageService.saveMessage(message);
    }

    // 채팅방 대화
    @MessageMapping("/chat/talk/{roomId}")
    @SendTo("/sub/chat/room/{roomId}")
    public MessageInfo talkUser(@DestinationVariable("roomId") Long roomId, @Payload MessageCreateRequest message){
        return messageService.saveMessage(message);
    }

    // 채팅방 퇴장
    @MessageMapping("/chat/exit/{roomId}")
    @SendTo("/sub/chat/room/{roomId}")
    public MessageInfo exitUser(@DestinationVariable("roomId") Long roomId, @Payload MessageCreateRequest message){
        message.setMessage(message.getSender() + "님이 채팅방에 퇴장하였습니다.");
        return messageService.saveMessage(message);
    }
}
