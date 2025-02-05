package com.stroev.storage;
import com.stroev.model.Resume;
import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage{
    protected void save_implementation(Resume r) {
        // -(insertion point) - 1 = b
        int b = Arrays.binarySearch(storage,0,id,r);
        System.arraycopy(storage, -b-1, storage, -b, id-b-1);
        storage[-b-1]=r;
    }
    public void delete_implementation(int index) {
        if (index>=0){
            System.arraycopy(storage, index+1, storage, index, id-index);
        }
    }
    protected int getIndex(String uuid){
        Resume key=new Resume(); //то что нужно найти
        key.setUuid(uuid);
        return Arrays.binarySearch(storage,0,id,key); // где от-до что ищем
    }
}
