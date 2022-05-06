import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ConstructPC extends JDialog{

    private JPanel constructPanel;
    private JButton btnLogout;
    private JList listComputersBuilt;
    private JComboBox cbComputerType;
    private JTextField tfRAM;
    private JTextField tfStorage;
    private JLabel lblLastPC;
    private JButton btnCreatePC;
    private JTextField tfCPU;
    private JTextField tfGPU;

    // ConstructPC konstruktor
    public ConstructPC(JFrame parent) {
        super(parent);
        setTitle("Számítógép összeállítása");
        setContentPane(constructPanel);
        setMinimumSize(new Dimension(1000, 750));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cbComputerType.setModel(new DefaultComboBoxModel<>(ComputerType.values()));

        // Kijelentkezés gomb
        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginForm loginForm = new LoginForm(null);
            }
        });

        // Összeállítás gomb
        btnCreatePC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(cbComputerType.getSelectedItem().toString());
                if (cbComputerType.getSelectedItem().toString() == "Notebook") {

                    System.out.println("Notebook selected");
                    String computerType = cbComputerType.getSelectedItem().toString();
                    String CPU = tfCPU.getText();
                    String RAM = tfRAM.getText();
                    String Storage = tfStorage.getText();
                    String GPU = tfGPU.getText();
                    //System.out.println(computerType + " " + CPU + " " + RAM + " " + Storage + " " + GPU);


                }
            }
        });
        setVisible(true);
    }
}
