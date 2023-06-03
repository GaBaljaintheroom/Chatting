package com.example.chatting.domain.chatRoom.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RoomUpdateRequest {

    @NotNull(message = "채팅방 아이디는 필수 입니다.")
    private Long id;

    @NotNull(message = "채팅방 이름은 필수 입니다.")
    private String name;
}
