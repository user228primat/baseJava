package com.stroev.storage;
import com.stroev.exception.ExistStorageException;
import com.stroev.exception.NotExistStorageException;
import com.stroev.exception.StorageException;
import com.stroev.model.Resume;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.List;

public abstract class AbstractArrayStorage extends AbstractStorage{
    protected static final int Limit = 10000;
    protected Resume[] storage = new Resume[Limit];
    protected int id=0;

    public List<Resume> getAllCopy() {
        return Arrays.asList(Arrays.copyOfRange(storage,0,id));
    }

    public int size() {
        return id;
    }
    public void clear() {
        Arrays.fill(storage,0,id,null);
        id=0;
    }
    protected Resume get_implements(String uuid){
        return storage[getIndex(uuid)];
    }
    protected void get_update(Resume r){
        storage[getIndex(r.getUuid())]=r;
    }
    protected void get_save(Resume r){
        if (id==Limit){
            throw new StorageException("Stack Overflow",r.getUuid());
        }else {
            save_implementation(r);
            id++;
        }
    }
    protected void get_delete(String uuid){
        delete_implementation(getIndex(uuid));
        storage[id - 1] = null;
        id--;
    }
    protected boolean exist(String uuid){
        return getIndex(uuid)>=0;
    }

    protected abstract int getIndex(String uuid);
    protected abstract void save_implementation(Resume r);
    protected abstract void delete_implementation(int index);
}