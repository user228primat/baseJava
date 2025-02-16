package com.stroev.exception;

public class StorageException extends RuntimeException {
    private final String uuid;
    public StorageException(String message, String uuid) {
        super(message);//конструктор, который передаст ошибку
        this.uuid = uuid;
    }
    public String getUuid() {
        return uuid;
    }
}
