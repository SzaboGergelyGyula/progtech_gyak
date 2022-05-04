import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.StandardSocketOptions;
import java.sql.*;

public class LoginForm extends JDialog {
    private JPanel loginPanel;
    private JTextField tfEmail;
    private JPasswordField pfPassword;
    private JButton btnLogin;
    private JButton btnClose;

    // LoginForm konstruktor
    public LoginForm(JFrame parent) {
        super(parent);
        setTitle("Bejelentkezés");
        setContentPane(loginPanel);
        setMinimumSize(new Dimension(550,450));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Bejelentkezés gomb
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = tfEmail.getText();
                String password = String.valueOf(pfPassword.getPassword());

                user = getAuthenticatedUser(email, password);

                // Sikeres bejelentkezés
                if (user != null)
                {
                    dispose();
                    JOptionPane.showMessageDialog(LoginForm.this,
                            "Sikeres bejelentkezés!",
                            "Bejelentkezés",
                            JOptionPane.INFORMATION_MESSAGE);
                    ConstructPC constructPC = new ConstructPC(null);
                }
                // Sikertelen bejelentkezés
                else {
                    JOptionPane.showMessageDialog(LoginForm.this,
                            "E-mail cím vagy jelszó helytelen!",
                            "Sikertelen bejelentkezés",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Kilépés gomb
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public User user;

    // User autentikáció
    private User getAuthenticatedUser(String email, String password) {
        User user = null;

        // DB kapcsolat
        final String DB_URL = "jdbc:mysql://localhost/progtech_kdpeq8_c54c3q";
        final String USERNAME = "root";
        final String PASSWORD = "";

        // Felhasználó adatainak lekérdezése
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM users WHERE email=? AND password=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = new User();
                user.username = resultSet.getString("username");
                user.email = resultSet.getString("email");
                user.password = resultSet.getString("password");
            }

            stmt.close();
            conn.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return user;
    }

    public static void main(String[] args) {
        LoginForm loginForm = new LoginForm(null);
        User user = loginForm.user;
        if (user != null) {
            System.out.println("Sikeres bejelentkezés: "+user.username);
            System.out.println("E-mail: "+user.email);
        } else {
            System.out.println("Bejelentkezés megszakítva");
        }
    }
}