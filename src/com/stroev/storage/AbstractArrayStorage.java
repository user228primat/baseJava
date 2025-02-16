package com.stroev.storage;
import com.stroev.exception.NotExistStorageException;
import com.stroev.model.Resume;
import java.util.Arrays;
import java.util.Objects;

public abstract class AbstractArrayStorage {
    private final int Limit = 10000;
    protected Resume[] storage = new Resume[Limit];
    protected int id=0;

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index !=-1) {
            return storage[index];
        }
        throw new NotExistStorageException(uuid);
    }
    public Resume[] getAll() {
        Resume[] all_res=new Resume[id];
        return Arrays.copyOfRange(storage,0,id);
    }
    public int size() {
        return id;
    }
    public void clear() {
        Arrays.fill(storage,0,id,null);
        id=0;
    }
    public void update(Resume r){
        int index = getIndex(r.getUuid());
        if(index>=0){
            storage[index]=r;
        }
    }
    public void save(Resume r){
        // еще есть место в массиве и такого эллемента нет
        if ( getIndex(r.getUuid()) >= 0 ){
            System.out.println("Element exists");
        }else if (id==Limit){
            System.out.println("Limit exceeded");
        }else {
            save_implementation(r);
            id++;
        }
    }
    public void delete(String uuid) {
        int index=getIndex(uuid);
        if(index<0){
            System.out.println("Index < 0");
        }else {
            delete_implementation(index);
            storage[id - 1] = null;
            id--;
        }
    }

    protected abstract int getIndex(String uuid);
    protected abstract void save_implementation(Resume r);
    protected abstract void delete_implementation(int index);
}