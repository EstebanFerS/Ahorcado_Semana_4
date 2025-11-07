/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ahorcado;

/**
 *
 * @author esteb
 */
public class JuegoAhorcadoFijo extends JuegoAhorcadoBase{

    
    
   public JuegoAhorcadoFijo(String palabra){
       super();
       this.palabraSecreta = palabra;
       inicializarPalabraSecreta();
   }
   
    @Override
    protected void actualizarPalabraActual(char letra) {
        }

    @Override
    protected void verificarLetra(char letra) {
    
    }

    @Override
    protected boolean hasGanado() {
        return true;
    }

    @Override
    public void inicializarPalabraSecreta() {
        palabraActual = new char[palabraSecreta.length()];
        for(int i = 0; i < palabraSecreta.length(); i++){
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
