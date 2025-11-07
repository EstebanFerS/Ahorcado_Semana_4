/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ahorcado;

import java.util.ArrayList;

/**
 *
 * @author esteb
 */
public abstract class JuegoAhorcadoBase implements JuegoAhorcado {

    protected String palabraSecreta;
    protected String palabraActual;
    protected int intentos;
    protected int limiteIntentos = 6;
    protected ArrayList<Character> letrasUsadas;
    protected ArrayList<String> figuraAhorcado;

    protected JuegoAhorcadoBase() {
        crearFigura();
        intentos = limiteIntentos;
    }

    protected void crearFigura() {
        figuraAhorcado.clear();
        figuraAhorcado.add("  _______\n"
                + " |/      |\n"
                + " |\n"
                + " |\n"
                + " |\n"
                + " |\n"
                + "|"
        );

        figuraAhorcado.add("  _______\n"
                + " |/      |\n"
                + " |      ( )\n"
                + " |\n"
                + " |\n"
                + " |\n"
                + "|"
        );
        figuraAhorcado.add(
                "  _______\n"
                + " |/      |\n"
                + " |      ( )\n"
                + " |       |\n"
                + " |\n"
                + " |\n"
                + "|"
        );

        figuraAhorcado.add(
                "  _______\n"
                + " |/      |\n"
                + " |      ( )\n"
                + " |      /|\n"
                + " |\n"
                + " |\n"
                + "|"
        );

        figuraAhorcado.add(
                "  _______\n"
                + " |/      |\n"
                + " |      ( )\n"
                + " |      /|\\\n"
                + " |\n"
                + " |\n"
                + "|"
        );

        figuraAhorcado.add(
                "  _______\n"
                + " |/      |\n"
                + " |      ( )\n"
                + " |      /|\\\n"
                + " |      / \\\n"
                + " |\n"
                + "|"
        );

    }

    protected abstract void actualizarPalabraActual(char letra);

    protected abstract void verificarLetra(char letra);

    protected abstract boolean hasGanado();

}
