package com.stroev.model;

import java.util.UUID;

/**
 * Initial resume class
 * TO DO r.ToString
 */
public class Resume implements Comparable<Resume>{
    private final String uuid;

    public Resume(String uuid) {
        this.uuid = uuid;
    }

    public Resume() {
        this(UUID.randomUUID().toString());
    }

    @Override
    public String toString() {
        return uuid;
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
    public boolean equals(Object o){
        if(this==o) return true;
        if (o==null || this.getClass()!=o.getClass()) return false;

        Resume resume=(Resume)o;

        return uuid.equals(resume.uuid);
    }

    @Override
    public int hashCode(){
        return uuid.hashCode();
    }
}
