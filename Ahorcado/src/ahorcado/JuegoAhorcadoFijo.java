/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ahorcado;

/**
 *
 * @author esteb
 */
public class JuegoAhorcadoFijo extends JuegoAhorcadoBase {

    public JuegoAhorcadoFijo(String palabra) throws PalabraNoValidaExcepcion{
        super();
       this.palabraSecreta = palabra;
       inicializarPalabraSecreta();
    }

    @Override
    protected void actualizarPalabraActual(char letra) {
        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == letra) {
                palabraActual[i] = letra;
            }
        }
    }

    @Override
    protected boolean verificarLetra(char letra) {
        return palabraSecreta.indexOf(letra) >= 0;
    }

    @Override
    protected boolean hasGanado() {
        for (char letra : palabraActual) {
            if (letra == '_') {
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
        palabraActual = new char[palabraSecreta.length()];
        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (Character.isLetter(palabraSecreta.charAt(i))) {
                palabraActual[i] = '_';
            } else {
                palabraActual[i] = palabraSecreta.charAt(i);
            }
        }
    }

    @Override
    public void jugar() {
        
    }
}
