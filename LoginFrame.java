import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {
    private DataStore store;

    public LoginFrame() {
        store = DataStore.load();

        setTitle("Product Finder - Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        JLabel lblUsername = new JLabel("Username:");
        JTextField txtUsername = new JTextField();

        JLabel lblPassword = new JLabel("Password:");
        JPasswordField txtPassword = new JPasswordField();

        JLabel lblRole = new JLabel("Role:");
        JComboBox<String> cmbRole = new JComboBox<>(new String[]{"User", "Owner"});

        JLabel lblStore = new JLabel("Store (Owner only):");
        JTextField txtStore = new JTextField();

        JButton btnLogin = new JButton("Login");
        JButton btnRegister = new JButton("Register");

        panel.add(lblUsername); panel.add(txtUsername);
        panel.add(lblPassword); panel.add(txtPassword);
        panel.add(lblRole); panel.add(cmbRole);
        panel.add(lblStore); panel.add(txtStore);
        panel.add(btnLogin); panel.add(btnRegister);

        add(panel);

        btnLogin.addActionListener(e -> {
            String username = txtUsername.getText().trim();
            String password = new String(txtPassword.getPassword()).trim();

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Enter username and password.");
                return;
            }

            User user = store.getUsers().get(username);
            if (user != null && user.getPassword().equals(password)) {
                JOptionPane.showMessageDialog(this, "Login successful!");
                new DashboardFrame(user, store);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password.");
            }
        });

        btnRegister.addActionListener(e -> {
            String username = txtUsername.getText().trim();
            String password = new String(txtPassword.getPassword()).trim();
            String role = (String) cmbRole.getSelectedItem();
            String storeName = txtStore.getText().trim();

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Enter username and password.");
                return;
            }

            if (store.getUsers().containsKey(username)) {
                JOptionPane.showMessageDialog(this, "Username already exists.");
                return;
            }

            User newUser = new User(username, password, role, role.equals("Owner") ? storeName : null);
            store.getUsers().put(username, newUser);
            store.save();

            JOptionPane.showMessageDialog(this, "Registration successful! Please login.");
        });

        setVisible(true);
    }
}
