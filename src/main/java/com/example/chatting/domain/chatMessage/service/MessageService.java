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

//    @Override
//    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//        String payload = message.getPayload();
//        ObjectMapper objectMapper = new ObjectMapper();
//        JsonNode jsonNode = objectMapper.readTree(payload);
//        String type = jsonNode.get("type").asText();
//        Long roomId = jsonNode.get("roomId").asLong();
//        String sender = jsonNode.get("sender").asText();
//        String comment = jsonNode.get("message").asText();
//        Room room = roomService.findOneRoom(roomId);
//
//        Message chatMessage = Message.builder()
//                .type(Type.valueOf(type))
//                .message(comment)
//                .sender(sender)
//                .room(room).build();
//        messageRepository.save(chatMessage);
//
//        handleActions(session, chatMessage);
//
//    }

//    public void handleActions(WebSocketSession session, Message chatMessage) throws Exception {
//
//        if (chatMessage.getType().equals(Type.ENTER)){
//            chatMessage.setMessage(chatMessage.getSender() + "님이 입장했습니다.");
//            messageRepository.save(chatMessage);
//            Set<WebSocketSession> roomSessions = sessions.getSessionsByRoomId(chatMessage.getRoom().getId());
//            roomSessions.add(session);
//            sendMessage(chatMessage);
//        } else if (chatMessage.getType().equals(Type.TALK)){
//            sendMessage(chatMessage);
//        } else if (chatMessage.getType().equals(Type.EXIT)){
//            chatMessage.setMessage(chatMessage.getSender() + "님이 퇴장했습니다.");
//            messageRepository.save(chatMessage);
//            sendMessage(chatMessage);
//            sessions.removeSession(session);
//        }
//
//    }
//
//
//    public void sendMessage(Message chatMessage) {
//        Set<WebSocketSession> roomSessions = sessions.getSessionsByRoomId(chatMessage.getRoom().getId());
//        roomSessions.parallelStream().forEach(session -> {
//            roomService.sendMessage(session, chatMessage);
//        });
//    }
//
//    @Override
//    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
//        super.afterConnectionClosed(session, status);
//    }


}
