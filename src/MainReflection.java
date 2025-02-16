import com.stroev.model.Resume;

import java.lang.reflect.Field;

public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException {
        //почему throws IllegalAccessException
        Resume r=new Resume("uuid228");
        //System.out.println(r.getClass().getDeclaredFields()[0].getName());
        //return: private final java.lang.String com.stroev.model.Resume.uuid
        Field declaredField = r.getClass().getDeclaredFields()[0]; //взяли поле класса
        declaredField.setAccessible(true);
        System.out.println(declaredField.get(r));
        //System.out.println(declaredField.getName());
        declaredField.set(r,"ppc");
        System.out.println(r);
    }
}
