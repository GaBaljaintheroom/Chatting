package com.example.chatting.domain.chatMessage.entity;


import com.example.chatting.domain.chatRoom.entity.Room;
import com.example.chatting.global.domain.BaseEntity;
import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.*;
import org.springframework.web.socket.WebSocketSession;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "ChatMessage")
public class Message extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "chatType", nullable = false)
    private Type type;

    @Column(name = "sender", nullable = false)
    private String sender;

    @Column(name = "message")
    private String message;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    public void setMessage(String message) {
        this.message = message;
    }

    @Builder
    public Message(Type type, String sender, String message, Room room){
        this.type = type;
        this.sender = sender;
        this.message = message;
        this.room = room;
    }
}
