/*
Сделать так, чтобы можно было иметь два экземпляра singletone объекта в Runtime.
 */

package firstDecision;

import java.lang.reflect.Field;

public class Runner {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {

        MySingleton mySingleton_1 = MySingleton.getMySingleton();

        Class clazz = MySingleton.class;
        Field field = clazz.getDeclaredField("mySingleton");
        field.setAccessible(true);
        field.set(mySingleton_1,null);

        MySingleton mySingleton_2 = MySingleton.getMySingleton();

        System.out.println(mySingleton_1.equals(mySingleton_2));
        System.out.println("mySingleton_1: " + mySingleton_1);
        System.out.println("mySingleton_2: " + mySingleton_2);

    }
}
