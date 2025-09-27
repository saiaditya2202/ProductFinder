import java.io.*;
import java.util.*;

public class DataStore implements Serializable {
    private Map<String, User> users = new HashMap<>();
    private Map<String, List<Product>> products = new HashMap<>();

    private static final String FILE_NAME = "DataStore.dat";

    public Map<String, User> getUsers() { return users; }
    public Map<String, List<Product>> getProducts() { return products; }

    public void save() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static DataStore load() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (DataStore) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new DataStore(); // return empty datastore if file not found
        }
    }
}
