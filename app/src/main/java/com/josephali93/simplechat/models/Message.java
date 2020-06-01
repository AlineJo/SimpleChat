package com.josephali93.simplechat.models;

public class Message {

    private String sender;
    private String content;
    private boolean isBelongsToCurrentUser;

    public Message(String sender, String content, boolean isBelongsToCurrentUser) {
        this.sender = sender;
        this.content = content;
        this.isBelongsToCurrentUser = isBelongsToCurrentUser;
    }

    public String getSender() {
        return sender;
    }

    public String getContent() {
        return content;
    }

    public boolean getIsBelongsToCurrentUser() {
        return isBelongsToCurrentUser;
    }
}
