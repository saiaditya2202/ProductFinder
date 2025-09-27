import javax.swing.*;
import java.awt.*;

public class DashboardFrame extends JFrame {
    private User user;
    private DataStore store;

    public DashboardFrame(User user, DataStore store) {
        this.user = user;
        this.store = store;

        setTitle("Dashboard - " + user.getUsername());
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        JButton searchBtn = new JButton("Search Product");

        panel.add(searchBtn);

        if (user.getRole().equalsIgnoreCase("Owner")) {
            JButton addBtn = new JButton("Add Product");
            JButton updateBtn = new JButton("Update Product");
            JButton deleteBtn = new JButton("Delete Product");
            panel.add(addBtn); panel.add(updateBtn); panel.add(deleteBtn);
        }

        JButton logoutBtn = new JButton("Logout");
        panel.add(logoutBtn);

        add(panel);
        setVisible(true);
    }
}
