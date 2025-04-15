package com.stroev.storage;
import com.stroev.model.Resume;
import java.util.Arrays;
import java.util.Comparator;

// -(insertion point) - 1 = b
public class SortedArrayStorage extends AbstractArrayStorage{

    private final static Comparator<Resume> RESUME_COMPARATOR = (Resume r1, Resume r2) -> {
        return r1.getUuid().compareTo(r2.getUuid());
    };

    /*
    private final static Comparator<Resume> RESUME_COMPARATOR = new Comparator<Resume>(){
        @Override
        public int compare(Resume r1, Resume r2) {
            return r1.getUuid().compareTo(r2.getUuid());
        }
    };

    private static class ResumeComparator implements Comparator<Resume>{
        @Override
        public int compare(Resume r1, Resume r2) {
            return r1.getUuid().compareTo(r2.getUuid());
        }
    }
     */
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
        Resume key=new Resume(uuid,"dummy"); //то что нужно найти
        return Arrays.binarySearch(storage,0,id,key,RESUME_COMPARATOR); // где от-до что ищем
    }
}
