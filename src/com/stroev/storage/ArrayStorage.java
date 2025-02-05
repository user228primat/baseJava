package com.stroev.storage;
import com.stroev.model.Resume;
import java.util.Arrays;
import java.util.Objects;

public class ArrayStorage extends AbstractArrayStorage {
    protected void save_implementation(Resume r) {
        storage[id] = r;
    }
    public void delete_implementation(int index) {
        storage[index]=storage[id-1];
    }
    protected int getIndex(String uuid){
        for(int i=0;i<id;i++){
            if(uuid.equals(storage[i].getUuid())){
                return i;
            }
        }
        return -1;
    }
}
