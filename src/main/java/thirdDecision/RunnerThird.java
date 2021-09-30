package thirdDecision;

import java.lang.reflect.InvocationTargetException;

public class RunnerThird {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String path = "thirdDecision.SingletonThird";
        ClassLoaderThird classLoaderThird = new ClassLoaderThird();
        Class clazz = classLoaderThird.findClass(path);
        Object firstSingleton= clazz.getMethod("getSingleton").invoke(clazz);
        System.out.println("firstSingleton: " + firstSingleton + "; loaded by: " + clazz.getClassLoader());

        ClassLoaderThird classLoaderThird2 = new ClassLoaderThird();
        Class clazz2 = classLoaderThird2.findClass(path);
        Object secondSingleton= clazz2.getMethod("getSingleton").invoke(clazz2);
        System.out.println("secondSingleton: " + secondSingleton + "; loaded by: " + clazz2.getClassLoader());

        System.out.println(firstSingleton.equals(secondSingleton));
    }
}
