/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ahorcado;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author DELL
 */
public class MenuPrincipal extends BaseGUI {

    private JPanel panelPrincipal;
    private JButton btnAgregarPalabra, btnJugarAzar, btnJugarFijo, btnSalir;
    private JLabel lblTitulo;

    public MenuPrincipal() {
        super("Menu Principal", 615, 500);
        initComponents();
    }

    public void initComponents() {
        panelPrincipal = createPanelPrincipal();
        panelPrincipal.setLayout(null);

        lblTitulo = createLabelTitle("AHORCADO", 215, 20, 220, 50);
        panelPrincipal.add(lblTitulo);

        btnAgregarPalabra = createBtn("Agregar Palabras");
        btnAgregarPalabra.setBounds(200, 130, 220, 50);
        panelPrincipal.add(btnAgregarPalabra);

        btnJugarAzar = createBtn("Jugar Ahorcado Azar");
        btnJugarAzar.setBounds(200, 210, 220, 50);
        panelPrincipal.add(btnJugarAzar);

        btnJugarFijo = createBtn("Jugar Ahorcado Fijo");
        btnJugarFijo.setBounds(200, 280, 220, 50);
        panelPrincipal.add(btnJugarFijo);
        
        btnSalir = createBtn("Salir");
        btnSalir.setBounds(460, 400, 80, 40);
        panelPrincipal.add(btnSalir);

        setContentPane(panelPrincipal);
    }

    public static void main(String[] args) {
        new MenuPrincipal().setVisible(true);
    }
}
