package com.example.chatting.domain.chatRoom.dto;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class Sessions {
    private final Map<Long, Set<WebSocketSession>> sessionsByRoomId = new ConcurrentHashMap<>();

    public Set<WebSocketSession> getSessionsByRoomId(Long roomId) {
        return sessionsByRoomId.computeIfAbsent(roomId, k -> new HashSet<>());
    }

    public void removeSession(WebSocketSession session) {
        sessionsByRoomId.values().forEach(sessions -> sessions.remove(session));
    }
}

