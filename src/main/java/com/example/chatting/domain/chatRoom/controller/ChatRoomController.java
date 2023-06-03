package com.example.chatting.domain.chatRoom.controller;


import com.example.chatting.domain.chatRoom.dto.request.RoomCreateRequest;
import com.example.chatting.domain.chatRoom.dto.request.RoomUpdateRequest;
import com.example.chatting.domain.chatRoom.dto.response.RoomInfo;
import com.example.chatting.domain.chatRoom.dto.response.RoomPageInfo;
import com.example.chatting.domain.chatRoom.service.RoomService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/chat")
public class ChatRoomController {
    private final RoomService roomService;

    @PostMapping
    public ResponseEntity<RoomInfo> createRoom(@Valid @RequestBody RoomCreateRequest createRequest){
        return ResponseEntity.ok(roomService.createRoom(createRequest));
    }

    @PatchMapping
    public ResponseEntity<RoomInfo> updateRoom(@Valid @RequestBody RoomUpdateRequest updateRequest){
        return ResponseEntity.ok(roomService.updateRoom(updateRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRoom(@PathVariable Long id){
        roomService.deleteRoom(id);
        return ResponseEntity.ok("삭제 완료");
    }

    @GetMapping
    public ResponseEntity<RoomPageInfo> findAllRoom(
            @RequestParam(defaultValue = "0") int offset,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(roomService.findAllRoomByPagination(offset, size));
    }

}
