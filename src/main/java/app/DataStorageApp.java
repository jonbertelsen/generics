package app;

import javax.xml.crypto.Data;
import java.nio.file.Path;

public class DataStorageApp {
    static void main() {

        DataStorage<String> memoryStorage = new MemoryStorage<>();
        String id1 = memoryStorage.store("Hello, world!");
        String id2 = memoryStorage.store("Hej Bornholm");
        printStorageObject(id1, memoryStorage);
        printStorageObject(id2, memoryStorage);

        DataStorage<Person> personDataStorage = new MemoryStorage<>();

        String p1Id = personDataStorage.store(new Person("Benny", 23));
        printStorageObject(p1Id, personDataStorage);

        DataStorage<Person> filePersonDataStorage = new FileStorage<>(Path.of(""), Person.class);
        String fileId1 = filePersonDataStorage.store(new Person("Bente", 22));
        String fileId2 = filePersonDataStorage.store(new Person("Peter", 43));

        printStorageObject(fileId2, filePersonDataStorage);

    }

    private static void printStorageObject(String id, DataStorage storage){
        System.out.println(storage.retrieve(id));
    }

    // Q: Hvad er et interface?
    // A: Det er en kontrakt, som fortæller hvilke metoder der skal være i en klasse
    // A: Dvs, at vi angiver metodesignaturer: Returtype, metodenavn og parameterliste
    // Q: Hvad er argumenter til en metode og hvad er parametre?
    // A: Argumenter er den man skriver når man kalder en metoder memoryStorage.store("Hello, world!");
    // Da er "Helle, world!" et argument
    // A: Parametre står i metodesignaturen. Fx. er "T data" en parameter i  String store(T data);

}
