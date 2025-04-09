package com.stroev.storage;

import com.stroev.exception.StorageException;
import com.stroev.model.Resume;

import java.util.Arrays;

public interface Storage {
    public Resume[] getAll();
    public Resume get(String uuid);
    public int size();
    public void clear();
    public void update(Resume r);
    public void save(Resume r);
    public void delete(String uuid);
}
