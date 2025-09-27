import java.io.Serializable;

public class Product implements Serializable {
    private String name;
    private String mall;
    private String floor;
    private String store;
    private boolean available;

    public Product(String name, String mall, String floor, String store, boolean available) {
        this.name = name;
        this.mall = mall;
        this.floor = floor;
        this.store = store;
        this.available = available;
    }

    public String getName() { return name; }
    public String getMall() { return mall; }
    public String getFloor() { return floor; }
    public String getStore() { return store; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
}
