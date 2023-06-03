package com.example.chatting.domain.chatRoom.repository;

import com.example.chatting.domain.chatRoom.entity.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query("select r from Room r where r.isActivate = true")
    Page<Room> findAllRoomByPagination(Pageable pageable);
}
