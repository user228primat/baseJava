import com.stroev.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //почему throws IllegalAccessException
        Resume r=new Resume("uuid228");

        Field declaredField = r.getClass().getDeclaredFields()[0]; //взяли поле класса
        declaredField.setAccessible(true);
        System.out.println(declaredField.get(r));
        declaredField.set(r,"ppc");
        System.out.println(r);

        Method getC = r.getClass().getDeclaredMethod("toString");
        String res = getC.invoke(r).toString();

        System.out.println("Method return: "+res);
    }
}
