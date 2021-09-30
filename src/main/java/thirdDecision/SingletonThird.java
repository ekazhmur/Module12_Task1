package thirdDecision;

import secondDecision.Singleton;

public class SingletonThird {
    private static SingletonThird singleton;

    private SingletonThird() {
    }

    public static SingletonThird getSingleton() {
        if (singleton == null) {
            singleton = new SingletonThird();
        }
        return singleton;
    }
}
