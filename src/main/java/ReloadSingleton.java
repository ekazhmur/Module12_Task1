import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;

public class ReloadSingleton {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        final Class<?> original = Singleton.class;
        URL loc = original.getProtectionDomain().getCodeSource().getLocation();
        ClassLoader parent = original.getClassLoader().getParent();
        Singleton first = Singleton.getSingleton();

        URLClassLoader cl = new URLClassLoader(new URL[]{loc}, parent);
        Class<?> duplicate = cl.loadClass(original.getName());
        Singleton second = Singleton.getSingleton();

        System.out.println("original: " + original + " (" + original.getClassLoader() + ')');
        System.out.println("duplicate: " + duplicate + " (" + duplicate.getClassLoader() + ')');
    }
}
class Singleton {
    private static Singleton singleton;

    private Singleton() {
    }

    public static Singleton getSingleton() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}