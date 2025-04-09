import com.stroev.model.Resume;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class MainCollections {
    public static void main(String[] args) {
        Resume r1=new Resume("uuid1");
        Resume r2=new Resume("uuid2");
        Resume r3=new Resume("uuid3");
        Resume r4=new Resume("uuid4");

        Collection<Resume> c = new ArrayList<>();
        c.add(r1);
        c.add(r2);
        c.add(r3);
        c.add(r4);

        Iterator<Resume> i = c.iterator();
        while(i.hasNext()){
            Resume r = i.next();
            System.out.println(r);

            if(r.getUuid().equals("uuid1")){
                i.remove();
            }
        }
        System.out.println(c.toString());

    }
}

