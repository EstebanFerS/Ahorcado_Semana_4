/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ahorcado;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Cantarero
 */
public class AdminPalabrasSecretas {

    public ArrayList<String> palabrasSecretas;
    public Random aleatorio;

    public AdminPalabrasSecretas() {
        palabrasSecretas = new ArrayList<>();
        aleatorio = new Random();
        
        palabrasSecretas.add("UNIVERSIDAD");
        palabrasSecretas.add("COMPUTACION");
        palabrasSecretas.add("CIUDAD");
        palabrasSecretas.add("AUTOMOVIL");
        palabrasSecretas.add("TELEVISOR");
        palabrasSecretas.add("MOTOCICLETA");
        palabrasSecretas.add("COMPUTADORA");
        palabrasSecretas.add("CALCULADORA");
    }

    public boolean AgregarPalabra(String Palabra) {
        if (Palabra == null || Palabra.isEmpty()) {
            return false;
        }
        for (String PlbTemp : palabrasSecretas) {
            if (!Palabra.equals(PlbTemp)) {
                palabrasSecretas.add(Palabra);
                return true;
            }

        }
        return false;

    }

    public String ObtenerPalabraAlAzar() {
        
        
        int NumAleatorio = aleatorio.nextInt(palabrasSecretas.size());
        return palabrasSecretas.get(NumAleatorio);
    }

}
