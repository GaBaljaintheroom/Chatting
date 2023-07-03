package com.example.chatting.domain.chatMessage.service;

import com.example.chatting.domain.chatMessage.dto.MessageInfo;
import com.example.chatting.domain.chatMessage.dto.mapper.MessageMapper;
import com.example.chatting.domain.chatMessage.dto.request.MessageCreateRequest;
import com.example.chatting.domain.chatMessage.entity.Message;
import com.example.chatting.domain.chatMessage.entity.Type;
import com.example.chatting.domain.chatMessage.repository.MessageRepository;
import com.example.chatting.domain.chatRoom.entity.Room;
import com.example.chatting.domain.chatRoom.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MessageService {
    private final RoomService roomService;
    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;

    // 메시지 저장
    public MessageInfo saveMessage(MessageCreateRequest request){
        Room currentRoom = roomService.findOneRoom(request.getRoomId());

        Message chatMessage = Message.builder()
                .type(Type.valueOf(request.getType()))
                .message(request.getMessage())
                .sender(request.getSender())
                .room(currentRoom)
                .build();
        messageRepository.save(chatMessage);
        return messageMapper.mapEntityToInfo(chatMessage);
    }
}
