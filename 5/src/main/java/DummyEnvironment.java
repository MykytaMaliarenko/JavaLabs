import interfaces.IConfiguration;
import interfaces.IContainer;
import interfaces.IEnvironment;

public class DummyEnvironment implements IEnvironment {

    @Override
    public IContainer configure(IConfiguration configuration) {
        DummyBinder binder = new DummyBinder();
        configuration.configure(binder);

        return new DummyContainer(binder.getBindings());
    }
}
