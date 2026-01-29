package app;

import java.util.*;

public class MemoryStorage<T> implements DataStorage<T> {
    private Map<String, T> storage = new HashMap<>();

    @Override
    public String store(T data) {
        String id = UUID.randomUUID().toString();
        storage.put(id, data);
        return id;
    }

    @Override
    public T retrieve(String id) {
        return storage.get(id);
    }
}
