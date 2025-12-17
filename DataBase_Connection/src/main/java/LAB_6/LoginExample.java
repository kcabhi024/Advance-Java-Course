package LAB_6;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class LoginExample extends JFrame {

    JTextField txtUsername;
    JPasswordField txtPassword;
    JButton btnSubmit;

    // Database connection
    private static final String URL = "jdbc:mysql://localhost:3306/labtest";
    private static final String USER = "root";
    private static final String PASS = "admin";

    public LoginExample() {
        setTitle("User Form");
        setSize(280, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2, 8, 8));

        panel.add(new JLabel("Username"));
        txtUsername = new JTextField();
        panel.add(txtUsername);

        panel.add(new JLabel("Password"));
        txtPassword = new JPasswordField();
        panel.add(txtPassword);

        btnSubmit = new JButton("Submit");
        panel.add(new JLabel());
        panel.add(btnSubmit);

        add(panel);

        btnSubmit.addActionListener(e -> insertAndFetch());
    }

    // ================= INSERT + FETCH =================
    private void insertAndFetch() {

        String username = txtUsername.getText();
        String password = new String(txtPassword.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter all fields");
            return;
        }

        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {

            // ---------- INSERT ----------
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO user (username, password) VALUES (?, ?)");
            ps.setString(1, username);
            ps.setString(2, password);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "User Added Successfully");

            txtUsername.setText("");
            txtPassword.setText("");

            // ---------- FETCH ----------
            CachedRowSet rowSet = RowSetProvider.newFactory().createCachedRowSet();
            rowSet.setUrl(URL);
            rowSet.setUsername(USER);
            rowSet.setPassword(PASS);
            rowSet.setCommand("SELECT user_id, username, password FROM user");
            rowSet.execute();

            // ---------- DISPLAY IN TERMINAL ----------
            ResultSetMetaData meta = rowSet.getMetaData();
            int cols = meta.getColumnCount();

            System.out.println("\nUser Table");
            for (int i = 1; i <= cols; i++)
                System.out.printf("%-15s", meta.getColumnName(i));
            System.out.println();

            rowSet.beforeFirst();
            while (rowSet.next()) {
                for (int i = 1; i <= cols; i++)
                    System.out.printf("%-15s", rowSet.getObject(i));
                System.out.println();
            }

            rowSet.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new LoginExample().setVisible(true);
    }
}
