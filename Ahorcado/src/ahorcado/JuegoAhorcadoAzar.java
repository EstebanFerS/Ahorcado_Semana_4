package ahorcado;

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
            if (palabraSecreta.charAt(i) == letra) {
                palabraActual[i] = letra;
            }
        }
    }

    @Override
    public boolean verificarLetra(char letra) {
        return palabraSecreta.indexOf(letra) >= 0;
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

        palabraActual = new char[palabraSecreta.length()];
        for (int i = 0; i < palabraSecreta.length(); i++) {
            palabraActual[i] = '_';
        }
        letrasUsadas.clear();
        intentos = limiteIntentos;
    }

    
    @Override
    public void jugar(String palabra) throws PalabraNoValidaExcepcion {
        this.PalabraSecrata = PalabraSecrata;
        inicializarPalabraSecreta();
    }
}
