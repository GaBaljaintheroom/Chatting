package com.example.chatting.domain.chatMessage.entity;

public enum Type {

    ENTER("입장"),
    TALK("채팅"),

    EXIT("퇴장");

    private final String description;

    Type(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}
