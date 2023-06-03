package com.example.chatting.domain.chatRoom.service;

import com.example.chatting.domain.chatMessage.dto.MessageInfo;
import com.example.chatting.domain.chatMessage.dto.mapper.MessageMapper;
import com.example.chatting.domain.chatMessage.entity.Message;
import com.example.chatting.domain.chatRoom.dto.request.RoomCreateRequest;
import com.example.chatting.domain.chatRoom.dto.response.RoomInfo;
import com.example.chatting.domain.chatRoom.dto.response.RoomPageInfo;
import com.example.chatting.domain.chatRoom.dto.request.RoomUpdateRequest;
import com.example.chatting.domain.chatRoom.entity.Room;
import com.example.chatting.domain.chatRoom.dto.mapper.RoomMapper;
import com.example.chatting.domain.chatRoom.repository.RoomRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoomService {

    private final ObjectMapper objectMapper;
    private final MessageMapper messageMapper;
    private final RoomRepository roomRepository;
    private final RoomMapper mapper;

    public RoomInfo createRoom(RoomCreateRequest request){
        Room newRoom = new Room(request.getName());
        return mapper.mapEntityToInfo(roomRepository.save(newRoom)) ;
    }

    public RoomInfo updateRoom(RoomUpdateRequest request){
        Room updateRoom = roomRepository.findById(request.getId()).orElseThrow(NullPointerException::new);
        updateRoom.updateRoomInfo(mapper.mapUpdateRequestToInfo(request));
        return mapper.mapEntityToInfo(roomRepository.save(updateRoom));
    }

    public void deleteRoom(Long id){
        Room deleteRoom = roomRepository.findById(id).orElseThrow(NullPointerException::new);
        deleteRoom.delete();
        roomRepository.save(deleteRoom);
    }

    @Transactional(readOnly = true)
    public Room findOneRoom(Long id){
        return roomRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    @Transactional(readOnly = true)
    public RoomPageInfo findAllRoomByPagination(int offset, int size){
        PageRequest pageRequest = PageRequest.of(offset, size);
        Page<Room> AllRoom = roomRepository.findAllRoomByPagination(pageRequest);
        return mapper.mapEntityToRoomPageInfo(AllRoom);
    }



    public <T> void sendMessage(WebSocketSession session, T message) {
        try{
            MessageInfo messageInfo = messageMapper.mapEntityToInfo((Message) message);
            session.sendMessage(new TextMessage(objectMapper.writeValueAsString(messageInfo)));
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

}
