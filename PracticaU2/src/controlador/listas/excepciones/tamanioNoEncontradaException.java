/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.listas.excepciones;

/**
 *
 * @author Usuario
 */
public class tamanioNoEncontradaException extends Exception{
    public tamanioNoEncontradaException(String msg){
        super(msg);
    }

    public tamanioNoEncontradaException() {
        super("la posicion dada no vale");
    }
    
    
    
}
