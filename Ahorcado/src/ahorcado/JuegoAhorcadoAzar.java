/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ahorcado;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cantarero
 */
public class JuegoAhorcadoAzar extends JuegoAhorcadoBase {

    public AdminPalabrasSecretas PalabraSecrata;

    public JuegoAhorcadoAzar(AdminPalabrasSecretas PalabraSecrata) throws PalabraNoValidaExcepcion {
        super();
        this.PalabraSecrata = PalabraSecrata;
        inicializarPalabraSecreta();
    }

    public void actualizarPalabraActual(char letra) {
        char letraMayus = Character.toUpperCase(letra);

        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == letraMayus) {
                palabraActual[i] = letraMayus;
            }
        }

    }

    @Override
    public boolean verificarLetra(char letra) {
        char LetraMayor = Character.toUpperCase(letra);
        for (char Chartmp : letrasUsadas) {
            if (Chartmp == LetraMayor) {
                try {
                    throw new LetraRepetidaExcepcion("La letra '" + LetraMayor + "' ya fue utilizada. Letras usadas: " + letrasUsadas);
                } catch (LetraRepetidaExcepcion ex) {
                    Logger.getLogger(JuegoAhorcadoAzar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == LetraMayor) {
            }
        }
        return false;
    }

    @Override
    public boolean hasGanado() {
        for (char c : palabraActual) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }

    @Override
    public void inicializarPalabraSecreta() throws PalabraNoValidaExcepcion {
        if (palabraSecreta == null || palabraSecreta.isEmpty()) {
            throw new PalabraNoValidaExcepcion("La palabra secreta no puede estar vacía.");
        }
        this.palabraSecreta = PalabraSecrata.ObtenerPalabraAlAzar();
        palabraActual = new char[palabraSecreta.length()];
        for (int i = 0; i < palabraSecreta.length(); i++) {
            palabraActual[i] = '_';
        }
        letrasUsadas.clear();
        intentos = limiteIntentos;
    }

    @Override
    public void jugar() {
    }

}
