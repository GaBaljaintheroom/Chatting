package com.example.chatting.domain.chatRoom.dto.mapper;

import com.example.chatting.domain.chatRoom.dto.response.RoomInfo;
import com.example.chatting.domain.chatRoom.dto.response.RoomPageInfo;
import com.example.chatting.domain.chatRoom.dto.request.RoomUpdateRequest;
import com.example.chatting.domain.chatRoom.entity.Room;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class RoomMapper {

    public RoomInfo mapEntityToInfo(Room room){
        return RoomInfo.builder()
                .id(room.getId())
                .name(room.getName())
                .createAt(room.getCreateAt())
                .build();
    }

    public RoomInfo mapUpdateRequestToInfo(RoomUpdateRequest updateRequest){
        return RoomInfo.builder().name(updateRequest.getName()).build();
    }

    public RoomPageInfo mapEntityToRoomPageInfo(Page<Room> RoomPage){
        List<RoomInfo> roomPageInfos = RoomPage.stream().map(this::mapEntityToInfo).collect(Collectors.toList());
        return RoomPageInfo.builder().roomInfoList(roomPageInfos).build();
    }
}
