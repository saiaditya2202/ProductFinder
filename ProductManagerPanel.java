import javax.swing.*;
import java.util.*;


public class ProductManagerPanel {
public static void showAddDialog(JFrame parent, User user, DataStore store) {
JTextField name = new JTextField();
JTextField mall = new JTextField();
JTextField floor = new JTextField();
JCheckBox available = new JCheckBox("Available");


Object[] fields = {"Name", name, "Mall", mall, "Floor", floor, available};


int option = JOptionPane.showConfirmDialog(parent, fields, "Add Product", JOptionPane.OK_CANCEL_OPTION);
if (option == JOptionPane.OK_OPTION) {
Product p = new Product(name.getText(), mall.getText(), floor.getText(), user.getStore(), available.isSelected());
store.getProducts().computeIfAbsent(name.getText().toLowerCase(), k -> new ArrayList<>()).add(p);
store.save();
JOptionPane.showMessageDialog(parent, "Product added!");
}
}


public static void showUpdateDialog(JFrame parent, User user, DataStore store) {
String pname = JOptionPane.showInputDialog(parent, "Enter product name to update:");
if (pname == null) return;
List<Product> list = store.getProducts().get(pname.toLowerCase());
if (list == null) {
JOptionPane.showMessageDialog(parent, "Product not found");
return;
}
JCheckBox available = new JCheckBox("Available");
int opt = JOptionPane.showConfirmDialog(parent, available, "Update Availability", JOptionPane.OK_CANCEL_OPTION);
if (opt == JOptionPane.OK_OPTION) {
for (Product p : list) p.setAvailable(available.isSelected());
store.save();
JOptionPane.showMessageDialog(parent, "Product updated!");
}
}


public static void showDeleteDialog(JFrame parent, User user, DataStore store) {
String pname = JOptionPane.showInputDialog(parent, "Enter product name to delete:");
if (pname == null) return;
if (store.getProducts().remove(pname.toLowerCase()) != null) {
store.save();
JOptionPane.showMessageDialog(parent, "Product deleted!");
} else {
JOptionPane.showMessageDialog(parent, "Product not found");
}
}


public static void showSearchDialog(JFrame parent, DataStore store) {
String pname = JOptionPane.showInputDialog(parent, "Enter product name to search:");
if (pname == null) return;
List<Product> list = store.getProducts().get(pname.toLowerCase());
if (list == null || list.isEmpty()) {
JOptionPane.showMessageDialog(parent, "No product found");
return;
}


StringBuilder sb = new StringBuilder();
Map<String, Boolean> malls = new HashMap<>();
}
}