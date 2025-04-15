package com.stroev.model;

import java.util.*;

/**
 * Initial resume class
 * TO DO r.ToString
 */
public class Resume implements Comparable<Resume>{
    private final String uuid;
    private String fullName;


    public Resume(String fullName) {
        this(UUID.randomUUID().toString(),fullName);
    }

    public Resume(String uuid,String fullName) {
        Objects.requireNonNull(uuid,"uuid is null");
        Objects.requireNonNull(fullName,"fullName is null");
        this.uuid = uuid;
        this.fullName=fullName;
    }

    @Override
    public String toString() {
        return uuid + '(' + fullName + ')';
    }

    public String getUuid() {
        return uuid;
    }

    //забыл как это работает
    @Override
    public int compareTo(Resume o) {
        return uuid.compareTo(o.uuid);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resume resume = (Resume) o;
        return Objects.equals(uuid, resume.uuid) && Objects.equals(fullName, resume.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, fullName);
    }

    public String getFullName() {
        return fullName;
    }
}
