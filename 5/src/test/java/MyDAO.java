import javax.inject.Inject;

public class MyDAO {
    private A a;

    private MySingleton singleton;

    public MyDAO() {}

    @Inject
    public MyDAO(A a, MySingleton instance) {
        this.a = a;
        this.singleton = instance;
    }

    public A getA() {
        return a;
    }

    public MySingleton getSingleton() {
        return singleton;
    }
}
