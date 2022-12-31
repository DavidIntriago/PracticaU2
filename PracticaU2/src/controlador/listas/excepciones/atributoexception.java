/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.listas.excepciones;

/**
 *
 * @author Usuario
 */
public class atributoexception extends Exception{
    public atributoexception(String message) {
        super(message);
    }
    
    public atributoexception() {
        super("No sse encuenntro atributo");
    }

}
