/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.listas.excepciones;

/**
 *
 * @author Usuario
 */
public class listanullExcepction extends Exception{

    
    public listanullExcepction(String message) {
        super(message);
    }
    
    public listanullExcepction() {
        super("Lista vacia pa");
    }

 
    
}
