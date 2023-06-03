package com.example.chatting.domain.chatMessage.dto;

import com.example.chatting.domain.chatMessage.entity.Type;
import lombok.*;

@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class MessageInfo {

    private Type type;
    private Long roomId;
    private String sender;
    private String message;
}
