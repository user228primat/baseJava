package com.stroev.storage;

import com.stroev.model.Resume;

import java.util.HashMap;

public class MapStorage extends AbstractStorage{
    public HashMap<String, Resume> storage = new HashMap<>();

    public Resume[] getAll() {
        return storage.values().toArray(new Resume[0]);
    }
    public int size() {
        return storage.size();
    }
    public void clear() {
        storage.clear();
    }
    @Override
    protected Resume get_implements(String uuid) {
        //Возможно выдает не object
        //System.out.println( storage.get(uuid));
        return (Resume) storage.get(uuid);
    }
    @Override
    protected void get_update(Resume r) {
        storage.replace(r.getUuid(),r);
    }
    @Override
    protected void get_save(Resume r) {
        storage.put(r.getUuid(),r);
    }
    @Override
    protected void get_delete(String uuid) {
        storage.remove(uuid);
    }
    @Override
    protected boolean exist(String uuid) {
        return get_implements(uuid)!=null;
    }
}
