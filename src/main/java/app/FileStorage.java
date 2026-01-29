package app;

public class FileStorage<T> implements DataStorage<T> {
    @Override
    public String store(T data) {
        return "";
    }

    @Override
    public T retrieve(String source) {
        return null;
    }
}
