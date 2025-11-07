package ahorcado;

import java.util.ArrayList;
import java.util.Random;

public final class AdminPalabrasSecretas {

    private static final AdminPalabrasSecretas INSTANCE = new AdminPalabrasSecretas();

    public final ArrayList<String> palabrasSecretas;
    public final Random aleatorio;

    private AdminPalabrasSecretas() {
        palabrasSecretas = new ArrayList<>();
        aleatorio = new Random();
        palabrasSecretas.add("UNIVERSIDAD");
        palabrasSecretas.add("COMPUTACION");
        palabrasSecretas.add("CIUDAD");
        palabrasSecretas.add("AUTOMOVIL");
        palabrasSecretas.add("TELEVISOR");
        palabrasSecretas.add("MAGO");
        palabrasSecretas.add("FILTRO");
        palabrasSecretas.add("THANOS");
    }

    public static AdminPalabrasSecretas getInstance() {
        return INSTANCE;
    }

    public boolean AgregarPalabra(String Palabra) {
        if (Palabra == null || Palabra.isEmpty()) {
            return false;
        }
        for (String s : palabrasSecretas) {
            if (s.equalsIgnoreCase(Palabra)) {
                return false;
            }
        }
        palabrasSecretas.add(Palabra.toUpperCase());
        return true;
    }

    public String ObtenerPalabraAlAzar() {
        if (palabrasSecretas.isEmpty()) {
            return "";
        }
        int i = aleatorio.nextInt(palabrasSecretas.size());
        return palabrasSecretas.get(i);
    }
}
