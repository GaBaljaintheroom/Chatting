package com.example.chatting.domain.chatMessage.dto.request;

import com.example.chatting.domain.chatMessage.entity.Type;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MessageCreateRequest {

    @NotNull(message = "채팅 타입은 필수 입니다.")
    private Type type;
    @NotNull(message = "채팅방 아이디는 필수 입니다.")
    private Long roomId;
    @NotNull(message = "채팅 송신자는 필수 입니다.")
    private String sender;
    @NotNull(message = "채팅 메시지는 필수 입니다.")
    private String message;
}
