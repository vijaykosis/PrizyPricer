package com.xebia.prizy.pricer.constant;

public enum MessageType {
    SUCCESS_MESSAGE("SUCCESS"),
    UNSUCCESS_MESSAGE("UNSUCCESS");

    private String messageType;

    MessageType(String type) {
        messageType = type;
    }

    public String getMessageType() {
        return messageType;
    }
}