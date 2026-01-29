package app;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

public class FileStorage<T> implements DataStorage<T> {

    private final ObjectMapper mapper = new ObjectMapper();
    private final Path baseDir;
    private final Class<T> type;

    public FileStorage(Path baseDir, Class<T> type) {
        this.baseDir = baseDir;
        this.type = type;

        try {
            Files.createDirectories(baseDir);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String store(T data) {
        try {
            String uuid = UUID.randomUUID().toString();

            Path file = baseDir.resolve(uuid + ".json");

            mapper.writeValue(file.toFile(), data);

            return uuid;

        } catch (IOException e) {
            throw new RuntimeException("Could not store object", e);
        }
    }

    @Override
    public T retrieve(String source) {
        try {
            Path file = baseDir.resolve(source + ".json");

            return mapper.readValue(file.toFile(), type);

        } catch (IOException e) {
            throw new RuntimeException("Could not retrieve object", e);
        }
    }
}
