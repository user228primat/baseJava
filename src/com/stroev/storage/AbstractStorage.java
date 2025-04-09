package com.stroev.storage;
import com.stroev.exception.ExistStorageException;
import com.stroev.exception.NotExistStorageException;
import com.stroev.exception.StorageException;
import com.stroev.model.Resume;
import java.util.Arrays;
import java.util.Objects;

public abstract class AbstractStorage implements Storage{

    public Resume get(String uuid) {
        if (exist(uuid)) {
            return get_implements(uuid);
        }
        throw new NotExistStorageException(uuid);
    }
    public void update(Resume r){
        if(exist(r.getUuid())){
            get_update(r);
        }else{
            throw new NotExistStorageException(r.getUuid());
        }
    }
    public void save(Resume r){
        if (exist(r.getUuid())){
            throw new ExistStorageException(r.getUuid());
        }else {
            get_save(r);
        }
    }
    public void delete(String uuid) {
        if(!exist(uuid)){
            throw new NotExistStorageException(uuid);
        }else {
            get_delete(uuid);
        }
    }

    protected abstract Resume get_implements(String uuid);
    protected abstract void get_update(Resume r);
    protected abstract void get_save(Resume r);
    protected abstract void get_delete(String uuid);
    protected abstract boolean exist(String uuid);

}