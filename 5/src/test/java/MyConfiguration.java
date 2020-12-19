import interfaces.IBinder;
import interfaces.IConfiguration;

public class MyConfiguration implements IConfiguration {
    @Override
    public void configure(IBinder binder) {
        binder.bind(MySingleton.class);
        binder.bind(MyPrototype.class);

        binder.bind(UseA.class);

        binder.bind(MyDAO.class);

        binder.bind(A.class, B.class);
        binder.bind(B.class, new B());
    }
}
