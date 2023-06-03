package com.example.chatting.domain.chatRoom.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.NotFound;

@Getter
@RequiredArgsConstructor
public class RoomCreateRequest {

    @NotNull(message = "채팅방 이름은 필수 입니다.")
    private String name;
}
