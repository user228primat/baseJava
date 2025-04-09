import com.stroev.model.Resume;
import com.stroev.storage.ListStorage;
import com.stroev.storage.MapStorage;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        ListStorage storage = new ListStorage();

        storage.save(new Resume("uuid1"));
        storage.save(new Resume("uuid2"));
        storage.save(new Resume("uuid3"));
        storage.save(new Resume("uuid4"));

        System.out.println("test -1:");
        storage.delete("uuid3");
        storage.update(new Resume("uuid2"));

        System.out.println("test0(size): "+storage.size());
        //Срабатывает
        System.out.println("test1(Get): " + storage.get("uuid1"));
        System.out.println("test2(getAll): ");

        for(Resume r:storage.getAll()){
            System.out.println(r);
        }


        storage.clear();
        System.out.println("test3(clear): "+storage.size());
    }
}

