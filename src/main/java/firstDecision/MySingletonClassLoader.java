package firstDecision;

import firstDecision.MySingleton;

public class MySingletonClassLoader extends ClassLoader{
    public Class<MySingleton> loadMySingletonClass() throws ClassNotFoundException {
        return (Class<MySingleton>) loadClass("firstDecision.MySingleton", false);
    }
}
