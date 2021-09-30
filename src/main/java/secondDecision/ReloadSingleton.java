package secondDecision;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;

public class ReloadSingleton {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        final Class<?> original = Singleton.class;
        URL loc = original.getProtectionDomain().getCodeSource().getLocation();
        ClassLoader parent = original.getClassLoader().getParent();
        Singleton firstSingleton = Singleton.getSingleton();

        URLClassLoader cl = new URLClassLoader(new URL[]{loc}, parent);
        Class<?> duplicate = cl.loadClass(original.getName());
        Object secondSingleton = duplicate.getMethod("getSingleton").invoke(Singleton.class);


        System.out.println("original: " + original + " (" + original.getClassLoader() + ')');
        System.out.println("duplicate: " + duplicate + " (" + duplicate.getClassLoader() + ')');
        System.out.println("firstSingleton == secondSingleton: " + firstSingleton.equals(secondSingleton));
        System.out.println("firstSingleton: " + firstSingleton);
        System.out.println("secondSingleton " + secondSingleton);
    }
}