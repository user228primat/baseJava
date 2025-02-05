package com.stroev.model;

/**
 * Initial resume class
 */
public class Resume implements Comparable<Resume>{
    // я не менял хэш-код
    // Unique identifier
    private String uuid;

    @Override
    public String toString() {
        return uuid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public int compareTo(Resume o) {
        return uuid.compareTo(o.uuid);
    }

    public boolean equals(Object o){
        if(this==o) return true;
        if (o==null || this.getClass()!=o.getClass()) return false;

        Resume resume=(Resume)o;

        return uuid.equals(resume.uuid);
    }
}
