package com.example.chatting.domain.chatMessage.dto.mapper;

import com.example.chatting.domain.chatMessage.dto.MessageInfo;
import com.example.chatting.domain.chatMessage.entity.Message;
import org.springframework.stereotype.Component;

@Component
public class MessageMapper {

    public MessageInfo mapEntityToInfo(Message message){
        return MessageInfo.builder()
                .type(message.getType())
                .roomId(message.getRoom().getId())
                .sender(message.getSender())
                .message(message.getMessage())
                .build();
    }
}
