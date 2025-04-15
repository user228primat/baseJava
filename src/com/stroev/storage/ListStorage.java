package com.stroev.storage;
import com.stroev.exception.ExistStorageException;
import com.stroev.exception.NotExistStorageException;
import com.stroev.exception.StorageException;
import com.stroev.model.Resume;

import java.util.*;

public class ListStorage extends AbstractStorage{
    private List<Resume> storage = new ArrayList<>();

    public int size() {
        return storage.size();
    }
    public void clear() {
        storage.clear();
    }

    @Override
    protected List<Resume> getAllCopy() {
        return new ArrayList<Resume>(storage);
    }

    @Override
    protected Resume get_implements(String uuid) {
        return (Resume) storage.get(getIndex(uuid));
    }

    @Override
    protected void get_update(Resume r) {
        storage.set(getIndex(r.getUuid()),r);
    }

    @Override
    protected void get_save(Resume r) {
        storage.add(r);
    }

    @Override
    protected void get_delete(String uuid) {
        storage.remove(getIndex(uuid));
    }

    @Override
    protected boolean exist(String uuid) {
        return getIndex(uuid)>=0;
    }

    private int getIndex(String uuid){
        //return storage.indexOf(new Resume(uuid));
        //к сожалению он сравнивает все поля, а надо uuid по методу compareTO
        for(int i=0;i<size();i++){
            if(storage.get(i).getUuid().equals(uuid)){
                return i;
            }
        }
        return -1;
    }
}
