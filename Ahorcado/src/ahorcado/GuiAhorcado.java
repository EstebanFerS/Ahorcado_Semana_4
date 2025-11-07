package ahorcado;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * GUI para el juego del Ahorcado.
 * Depende de:
 *  - BaseGUI (clase auxiliar para crear labels/buttons/panels)
 *  - JuegoAhorcadoBase, JuegoAhorcadoFijo, JuegoAhorcadoAzar
 *  - AdminPalabrasSecretas (Singleton)
 *  - MenuPrincipal (para volver al menú)
 */
public class GuiAhorcado extends BaseGUI {

    private JPanel panelPrincipal;
    private JLabel lblTitulo, lblIntentos, lblPalabraActual;
    private JButton btnAdivinar, btnNuevoJuego, btnSalir;
    private JTextField txtLetra;
    private JTextArea taFigura;
    private JScrollPane spRepetidas;
    private DefaultTableModel modeloRepetidas;
    private final String modo;
    private JuegoAhorcadoBase juego;
    private final String palabraFija;

    public GuiAhorcado(String modo) {
        super("Ahorcado", 770, 560);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.modo = modo;
        this.palabraFija = null;
        initComponents();
        iniciarJuego();
        render();
    }

    public GuiAhorcado(String modo, String palabraFija) {
        super("Ahorcado", 770, 560);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.modo = modo;
        this.palabraFija = palabraFija;
        initComponents();
        iniciarJuego();
        render();
    }

    private void iniciarJuego() {
        try {
            if (modo != null && modo.toUpperCase().contains("AZAR")) {
                juego = new JuegoAhorcadoAzar(AdminPalabrasSecretas.getInstance());
            } else {
                String p = (palabraFija == null) ? "" : palabraFija.toUpperCase();
                juego = new JuegoAhorcadoFijo(p);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al iniciar el juego: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            juego = null;
            if (btnAdivinar != null) btnAdivinar.setEnabled(false);
        }
    }

    public void initComponents() {
        panelPrincipal = createPanelPrincipal();
        panelPrincipal.setLayout(null);
        setContentPane(panelPrincipal);

        lblTitulo = createLabelTitle(modo == null ? "AHORCADO" : modo, 235, 20, 300, 50);
        panelPrincipal.add(lblTitulo);

        lblIntentos = createLabel("Intentos restantes: ", 20, 100, 280, 50);
        panelPrincipal.add(lblIntentos);

        lblPalabraActual = createLabel("_ _ _ _ _ _ _ _ _ _", 320, 160, 260, 50);
        panelPrincipal.add(lblPalabraActual);

        txtLetra = createTextField(400, 230, 40, 40);
        panelPrincipal.add(txtLetra);

        btnAdivinar = createBtn("Adivinar letra");
        btnAdivinar.setBounds(360, 290, 120, 40);
        btnAdivinar.setFont(btnAdivinar.getFont().deriveFont(Font.BOLD, 12f));
        panelPrincipal.add(btnAdivinar);

        taFigura = new JTextArea();
        taFigura.setBounds(60, 150, 200, 250);
        taFigura.setEditable(false);
        taFigura.setFont(new Font("Monospaced", Font.PLAIN, 12));
        panelPrincipal.add(taFigura);

        spRepetidas = createTable(new String[]{"Letras repetidas"}, new Object[][]{}, 28);
        spRepetidas.setBounds(550, 230, 170, 190);
        JTable t = (JTable) spRepetidas.getViewport().getView();
        modeloRepetidas = new DefaultTableModel(new Object[]{"Letras repetidas"}, 0);
        t.setModel(modeloRepetidas);
        panelPrincipal.add(spRepetidas);

        btnNuevoJuego = createBtn("Nuevo Juego");
        btnNuevoJuego.setBounds(340, 470, 140, 40);
        panelPrincipal.add(btnNuevoJuego);

        btnSalir = createBtn("Salir");
        btnSalir.setBounds(500, 470, 140, 40);
        btnSalir.setBackground(Color.red);
        panelPrincipal.add(btnSalir);

        // Listeners
        btnSalir.addActionListener(e -> {
            new MenuPrincipal().setVisible(true);
            dispose();
        });

        btnNuevoJuego.addActionListener(e -> {
            if (modo != null && modo.toUpperCase().contains("AZAR")) {
                new GuiAhorcado(modo).setVisible(true);
            } else {
                String nueva = JOptionPane.showInputDialog(this, "Ingrese la nueva palabra para modo FIJO:");
                if (nueva != null && !nueva.equals("")) {
                    new GuiAhorcado(modo, nueva).setVisible(true);
                } else {
                    return;
                }
            }
            dispose();
        });

        btnAdivinar.addActionListener(e -> adivinar());
        txtLetra.addActionListener(e -> adivinar());
    }

    private void adivinar() {
        if (juego == null) return;

        String s = txtLetra.getText();
        if (s == null || s.length() == 0) {
            txtLetra.setText("");
            return;
        }

        char c = Character.toUpperCase(s.charAt(0));

        if (!Character.isLetter(c)) {
            txtLetra.setText("");
            return;
        }

        if (juego.letrasUsadas.contains(c)) {
            if (!yaListado(c)) {
                modeloRepetidas.addRow(new Object[]{String.valueOf(c)});
            }
        } else {
            juego.letrasUsadas.add(c);

            boolean ok = juego.verificarLetra(c);
            if (ok) {
                juego.actualizarPalabraActual(c);
            } else {
                juego.intentos = Math.max(0, juego.intentos - 1);
                if (!yaListado(c)) {
                    modeloRepetidas.addRow(new Object[]{String.valueOf(c)});
                }
            }
        }

        txtLetra.setText("");
        render();

        if (juego.hasGanado()) {
            JOptionPane.showMessageDialog(this, "¡Ganaste! La palabra era: " + juego.palabraSecreta,
                    "Ahorcado", JOptionPane.INFORMATION_MESSAGE);
            btnAdivinar.setEnabled(false);
        } else if (juego.intentos == 0) {
            JOptionPane.showMessageDialog(this, "Perdiste. La palabra era: " + juego.palabraSecreta,
                    "Ahorcado", JOptionPane.ERROR_MESSAGE);
            btnAdivinar.setEnabled(false);
        }
    }

    private boolean yaListado(char c) {
        for (int i = 0; i < modeloRepetidas.getRowCount(); i++) {
            if (modeloRepetidas.getValueAt(i, 0).toString().equalsIgnoreCase(String.valueOf(c))) {
                return true;
            }
        }
        return false;
    }

    private void render() {
        if (juego == null) return;
        lblIntentos.setText("Intentos restantes: " + juego.intentos + "/" + juego.limiteIntentos);
        lblPalabraActual.setText(formatearPalabra(juego.palabraActual));
        int etapa = juego.limiteIntentos - juego.intentos;
        etapa = Math.max(0, Math.min(etapa, juego.figuraAhorcado.size() - 1));
        taFigura.setText(juego.figuraAhorcado.get(etapa));
    }

    private String formatearPalabra(char[] arr) {
        String res = "";
        for (int i = 0; i < arr.length; i++) {
            if (!res.equals("")) res = res + ' ';
            res = res + arr[i];
        }
        return res;
    }
}
