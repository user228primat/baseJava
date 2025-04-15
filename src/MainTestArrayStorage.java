import com.stroev.model.Resume;
import com.stroev.storage.ArrayStorage;
import com.stroev.storage.SortedArrayStorage;

/**
 * Test for your com.stroev.storage.ArrayStorage implementation
 */
public class MainTestArrayStorage {
    private static final SortedArrayStorage ARRAY_STORAGE = new SortedArrayStorage();
    //private static final ArrayStorage ARRAY_STORAGE = new ArrayStorage();
    /*
    public static void main(String[] args) {
        final Resume r1 = new Resume("uuid6");
        final Resume r2 = new Resume("uuid2");
        final Resume r3 = new Resume("uuid4");
        final Resume r4 = new Resume("uuid3");
        ARRAY_STORAGE.save(r1);//0
        ARRAY_STORAGE.save(r2);//1
        ARRAY_STORAGE.save(r3);//3
        ARRAY_STORAGE.save(r4);//x=2

        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());

        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));

        printAll();
        ARRAY_STORAGE.delete(r2.getUuid());
        printAll();
        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAll()) {
            System.out.println(r);
        }
    }
     */
}
