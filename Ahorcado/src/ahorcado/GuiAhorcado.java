package ahorcado;

import java.awt.*;
import javax.swing.*;

public class GuiAhorcado extends BaseGUI {

    private JPanel panelPrincipal;
    private JLabel lblTitulo, lblIntentos;
    private JButton btnAdivinar;

    private JTextArea taFigura;
    
    private String modo;

    public GuiAhorcado(String modo) {
        super("Menu Principal", 770, 600);
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

        taFigura = new JTextArea();
        taFigura.setBounds(60, 150, 200, 250);
        taFigura.setEditable(false);
        panelPrincipal.add(taFigura);
    }

    public static void main(String[] args) {
        new GuiAhorcado("AHORCADO FIJO").setVisible(true);
    }
}
