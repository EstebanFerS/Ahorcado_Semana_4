package ahorcado;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PalabrasSecretasGUI extends BaseGUI {

    private JPanel panelPrincipal;
    private JButton btnAgregarPalabra, btnSalir;
    private JLabel lblTitulo, lblNueva;
    private JTextField txtPalabra;
    private JScrollPane palabrasActuales;
    private DefaultTableModel modelo;
    private final AdminPalabrasSecretas admin = AdminPalabrasSecretas.getInstance();

    public PalabrasSecretasGUI() {
        super("Administrar Palabras Secretas", 615, 520);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initComponents();
    }

    public void initComponents() {
        panelPrincipal = createPanelPrincipal();
        panelPrincipal.setLayout(null);

        lblTitulo = createLabelTitle("PALABRAS SECRETAS", 115, 20, 400, 50);
        panelPrincipal.add(lblTitulo);

        lblNueva = createLabel("Nueva palabra:", 60, 120, 200, 40);
        panelPrincipal.add(lblNueva);

        txtPalabra = createTextField(60, 170, 270, 40);
        panelPrincipal.add(txtPalabra);

        btnAgregarPalabra = createBtn("Agregar Palabra");
        btnAgregarPalabra.setBounds(350, 170, 160, 40);
        panelPrincipal.add(btnAgregarPalabra);

        palabrasActuales = createTable(new String[]{"Palabra"}, new Object[][]{}, 28);
        palabrasActuales.setBounds(60, 240, 450, 180);
        panelPrincipal.add(palabrasActuales);

        JTable t = (JTable) palabrasActuales.getViewport().getView();
        modelo = new DefaultTableModel(new Object[]{"Palabra"}, 0);
        t.setModel(modelo);
        admin.palabrasSecretas.forEach(s -> modelo.addRow(new Object[]{s}));

        btnSalir = createBtn("Salir");
        btnSalir.setBounds(470, 440, 80, 30);
        btnSalir.setBackground(Color.red);
        panelPrincipal.add(btnSalir);

        btnAgregarPalabra.addActionListener(e -> {
            String p = txtPalabra.getText().trim();
            if (admin.AgregarPalabra(p)) {
                modelo.addRow(new Object[]{p.toUpperCase()});
                txtPalabra.setText("");
                txtPalabra.requestFocus();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo agregar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        });

        txtPalabra.addActionListener(e -> btnAgregarPalabra.doClick());

        btnSalir.addActionListener(e -> {
            new MenuPrincipal().setVisible(true);
            dispose();
        });

        setContentPane(panelPrincipal);
    }

    public static void main(String[] args) {
        new PalabrasSecretasGUI().setVisible(true);
    }
}
