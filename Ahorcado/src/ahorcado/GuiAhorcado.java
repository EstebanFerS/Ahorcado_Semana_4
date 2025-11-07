package ahorcado;

import java.awt.*;
import javax.swing.*;

public class GuiAhorcado extends BaseGUI {

    private JPanel panelPrincipal;
    private JLabel lblTitulo, lblIntentos, lblPalabraActual;
    private JButton btnAdivinar, btnNuevoJuego, btnSalir;
    private JTextField txtLetra;
    private JTextArea taFigura;
    private JScrollPane spRepetidas;
    private final String modo;

    public GuiAhorcado(String modo) {
        super("Ahorcado", 770, 560);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.modo = modo;
        initComponents();
    }

    public void initComponents() {
        panelPrincipal = createPanelPrincipal();
        panelPrincipal.setLayout(null);
        setContentPane(panelPrincipal);

        lblTitulo = createLabelTitle(modo, 235, 20, 300, 50);
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
        panelPrincipal.add(taFigura);

        spRepetidas = createTable(new String[]{"Letras repetidas"}, new Object[][]{}, 28);
        spRepetidas.setBounds(550, 230, 170, 190);
        panelPrincipal.add(spRepetidas);

        btnNuevoJuego = createBtn("Nuevo Juego");
        btnNuevoJuego.setBounds(340, 470, 140, 40);
        panelPrincipal.add(btnNuevoJuego);

        btnSalir = createBtn("Salir");
        btnSalir.setBounds(500, 470, 140, 40);
        panelPrincipal.add(btnSalir);

        btnSalir.addActionListener(e -> {
            new MenuPrincipal().setVisible(true);
            dispose();
        });

        btnNuevoJuego.addActionListener(e -> {
            GuiAhorcado g = new GuiAhorcado(modo);
            g.setVisible(true);
            dispose();
        });
    }

    public static void main(String[] args) {
        new GuiAhorcado("AHORCADO FIJO").setVisible(true);
    }
}
