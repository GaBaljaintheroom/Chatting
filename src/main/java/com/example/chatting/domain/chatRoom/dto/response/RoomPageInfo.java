package com.example.chatting.domain.chatRoom.dto.response;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RoomPageInfo {
    List<RoomInfo> roomInfoList = new ArrayList<>();
}
