package com.stroev.storage;
import com.stroev.model.Resume;
import java.util.Arrays;

// -(insertion point) - 1 = b
public class SortedArrayStorage extends AbstractArrayStorage{
    protected void save_implementation(Resume r) {
        int lim = AbstractArrayStorage.Limit;
        int b = Arrays.binarySearch(storage,0,id,r);
        int InsP = -b-1;
        System.arraycopy(storage, InsP, storage, (InsP+1)%lim, id-InsP);
        storage[InsP]=r;
    }
    public void delete_implementation(int index) {
        if (index>=0){
            System.arraycopy(storage, index+1, storage, index, id-index);
        }
    }
    protected int getIndex(String uuid){
        Resume key=new Resume(uuid); //то что нужно найти
        return Arrays.binarySearch(storage,0,id,key); // где от-до что ищем
    }
}
