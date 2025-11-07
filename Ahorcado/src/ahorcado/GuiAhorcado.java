package ahorcado;

import java.awt.*;
import javax.swing.*;

public class GuiAhorcado extends BaseGUI {

    private JPanel panelPrincipal;
    private JLabel lblTitulo, lblIntentos, lblPalabraActual;
    private JButton btnAdivinar, btnNuevoJuego, btnSalir;
    private JTextField txtLetra;

    private JTextArea taFigura;

    private final String modo;

    public GuiAhorcado(String modo) {
        super("Menu Principal", 770, 660);
        this.modo = modo;
        initComponents();
    }

    public void initComponents() {
        panelPrincipal = createPanelPrincipal();
        panelPrincipal.setLayout(null);
        setContentPane(panelPrincipal);

        lblTitulo = createLabelTitle(modo, 245, 20, 280, 50);
        panelPrincipal.add(lblTitulo);

        lblIntentos = createLabel("Intentos restantes: ", 20, 100, 280, 50);
        panelPrincipal.add(lblIntentos);

        lblPalabraActual = createLabel("_ _ _ _ _ _ _ _ _ _", 400, 170, 280, 50);
        panelPrincipal.add(lblPalabraActual);

        btnAdivinar = createBtn("Adivinar letra");
        btnAdivinar.setBounds(440, 300, 120, 40);
        btnAdivinar.setFont(btnAdivinar.getFont().deriveFont(Font.BOLD, 12f));
        panelPrincipal.add(btnAdivinar);
        
        txtLetra = createTextField(475, 240, 40, 40);
        panelPrincipal.add(txtLetra);

        taFigura = new JTextArea();
        taFigura.setBounds(60, 150, 200, 250);
        taFigura.setEditable(false);
        panelPrincipal.add(taFigura);
        
        btnNuevoJuego = createBtn("Nuevo Juego");
        btnNuevoJuego.setBounds(380, 550, 140, 40);
        panelPrincipal.add(btnNuevoJuego);
        
        btnSalir = createBtn("Salir");
        btnSalir.setBounds(560, 550, 140, 40);
        panelPrincipal.add(btnSalir);
    }

    public static void main(String[] args) {
        new GuiAhorcado("AHORCADO FIJO").setVisible(true);
    }
}
