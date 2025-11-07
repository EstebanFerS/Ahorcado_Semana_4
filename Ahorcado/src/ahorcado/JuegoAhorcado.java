/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ahorcado;

/**
 *
 * @author Cantarero
 */
public interface JuegoAhorcado {
    void inicializarPalabraSecreta()throws PalabraNoValidaExcepcion; 
    void jugar(String palabra) throws PalabraNoValidaExcepcion;
}
