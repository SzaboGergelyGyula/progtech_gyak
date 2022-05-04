import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConstructPC extends JDialog{

    private JPanel constructPanel;
    private JButton btnLogout;

    // ConstructPC konstruktor
    public ConstructPC(JFrame parent) {
        super(parent);
        setTitle("Számítógép összeállítása");
        setContentPane(constructPanel);
        setMinimumSize(new Dimension(900, 600));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Kijelentkezés gomb
        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginForm loginForm = new LoginForm(null);
            }
        });
        setVisible(true);
    }
}
