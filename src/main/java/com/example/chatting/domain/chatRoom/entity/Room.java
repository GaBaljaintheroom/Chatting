package com.example.chatting.domain.chatRoom.entity;

import com.example.chatting.domain.chatMessage.entity.Message;
import com.example.chatting.domain.chatMessage.entity.Type;
import com.example.chatting.domain.chatRoom.dto.response.RoomInfo;
import com.example.chatting.domain.chatRoom.service.RoomService;
import com.example.chatting.global.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "ChattingRoom")
public class Room extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "roomName", nullable = false)
    private String name;

    @OneToMany(mappedBy = "room")
    private List<Message> chattingMessages = new ArrayList<>();

    public Room(String name){
        this.name = name;
    }

    public void updateRoomInfo(RoomInfo roomInfo){
     this.name = roomInfo.getName();
    }

    public void delete(){
        this.activeOff();
    }



}
