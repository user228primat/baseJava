package com.stroev.storage;

import com.stroev.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapStorage extends AbstractStorage{
    public HashMap<String, Resume> storage = new HashMap<>();

    @Override
    public List<Resume> getAllCopy() {
        return new ArrayList<>(storage.values());
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
        return storage.get(uuid);
    }
    @Override
    protected void get_update(Resume r) {
        storage.put(r.getUuid(),r);
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
