package interfaces;

public interface IContainer {
    <T> T getComponent(Class<T> clazz);
}
