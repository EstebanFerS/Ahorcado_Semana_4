package ahorcado;

import java.util.logging.Level;
import java.util.logging.Logger;

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
        char L = Character.toUpperCase(letra);
        for (char x : letrasUsadas) {
            if (x == L) {
                try {
                    throw new LetraRepetidaExcepcion("La letra '" + L + "' ya fue utilizada.");
                } catch (LetraRepetidaExcepcion ex) {
                    Logger.getLogger(JuegoAhorcadoAzar.class.getName()).log(Level.WARNING, ex.getMessage());
                }
                return false;
            }
        }
        return palabraSecreta.indexOf(L) >= 0;
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
        this.palabraSecreta = PalabraSecrata.ObtenerPalabraAlAzar();
        if (palabraSecreta == null || palabraSecreta.isEmpty()) {
            throw new PalabraNoValidaExcepcion("La palabra secreta no puede estar vacía.");
        }
        this.palabraSecreta = PalabraSecrata.ObtenerPalabraAlAzar();
        palabraActual = new char[palabraSecreta.length()];
        for (int i = 0; i < palabraSecreta.length(); i++) {
            palabraActual[i] = Character.isLetter(palabraSecreta.charAt(i)) ? '_' : palabraSecreta.charAt(i);
        }
        letrasUsadas.clear();
        intentos = limiteIntentos;
    }

    @Override
    public void jugar() {
    }
}
