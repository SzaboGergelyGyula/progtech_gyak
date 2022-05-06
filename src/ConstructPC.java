import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

public class ConstructPC extends JDialog{

    DefaultListModel DLM = new DefaultListModel();

    private void addToList(String builtComputer) {
        listComputersBuilt.setModel(DLM);
        DLM.addElement(builtComputer);
    }

    private JPanel constructPanel;
    private JButton btnLogout;
    private JList listComputersBuilt;
    private JComboBox cbComputerType;
    private JTextField tfRAM;
    private JTextField tfStorage;
    private JLabel lblLastPCid;
    private JButton btnCreatePC;
    private JTextField tfCPU;
    private JTextField tfGPU;
    private JButton btnClear;
    private JLabel lblLastCPU;
    private JLabel lblLastRAM;
    private JLabel lblLastStorage;
    private JLabel lblLastGPU;

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
                //System.out.println(cbComputerType.getSelectedItem().toString()+" in combobox selected");
                String CPU = tfCPU.getText();
                String RAM = tfRAM.getText();
                String Storage = tfStorage.getText();
                String GPU = tfGPU.getText();
                String computerType = cbComputerType.getSelectedItem().toString();
                switch (cbComputerType.getSelectedItem().toString()){
                    case "Notebook":
                        Computer notebook = ComputerFactory.getComputer("Notebook");
                        notebook.construct(CPU, RAM, Storage, GPU);
                        lblLastPCid.setText(notebook.toString());
                        break;
                    case "PC":
                        Computer pc = ComputerFactory.getComputer("PC");
                        pc.construct(CPU, RAM, Storage, GPU);
                        lblLastPCid.setText(pc.toString());
                        break;
                    case "Szerver":
                        Computer server = ComputerFactory.getComputer("Server");
                        server.construct(CPU, RAM, Storage, GPU);
                        lblLastPCid.setText(server.toString());
                        break;
                }
                lblLastCPU.setText("Processzor: "+CPU);
                lblLastRAM.setText("Memória: "+RAM);
                lblLastStorage.setText("Tárhely: "+Storage);
                lblLastGPU.setText("Grafikus kártya: "+GPU);
                String builtComputer = computerType +" "+ CPU +" "+ RAM +" "+ Storage +" "+ GPU;
                addToList(builtComputer);
            }
        });
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfCPU.setText("");
                tfRAM.setText("");
                tfStorage.setText("");
                tfGPU.setText("");
            }
        });
        setVisible(true);
    }
}
