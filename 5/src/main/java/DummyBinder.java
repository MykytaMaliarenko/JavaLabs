import interfaces.IBinder;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Singleton;
import javax.inject.Inject;

public class DummyBinder implements IBinder {

    private List<DummyContainerValue<?>> bindings;

    public DummyBinder() {
        this.bindings = new LinkedList<>();
    }

    @Override
    public <T> void bind(Class<T> clazz) {
        DummyContainerValue<T> containerValue = new DummyContainerValue<>(clazz,
                clazz, this.getConstructorArgs(clazz),
                this.hasSingletonAnnotation(clazz), false);

        this.bindings.add(containerValue);
    }

    @Override
    public <T> void bind(Class<T> clazz, Class<? extends T> implementation) {
        DummyContainerValue<T> containerValue = new DummyContainerValue<>(clazz,
                implementation, this.getConstructorArgs(implementation),
                this.hasSingletonAnnotation(implementation), false);
        this.bindings.add(containerValue);
    }

    @Override
    public <T> void bind(Class<T> clazz, T instance) {
        DummyContainerValue<T> containerValue = new DummyContainerValue<>(clazz,
                instance, new Class[]{}, false, true);
        this.bindings.add(containerValue);
    }

    private <T> boolean hasSingletonAnnotation(Class<T> clazz) {
        for (Annotation annotation : clazz.getAnnotations()) {
            Class<? extends Annotation> type = annotation.annotationType();
            if (type.equals(Singleton.class))
                return true;
        }

        return false;
    }

    private <T> Class[] getConstructorArgs(Class<T> clazz) {
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor<?> constructor: constructors) {
            if (constructor.isAnnotationPresent(Inject.class))
                return constructor.getParameterTypes();
        }

        return constructors[0].getParameterTypes();
    }

    public List<DummyContainerValue<?>> getBindings() {
        return this.bindings;
    }
}
