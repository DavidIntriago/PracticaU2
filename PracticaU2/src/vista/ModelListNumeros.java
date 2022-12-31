/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.listas.ListaEnlazada;
import controlador.listas.NodoLista;
import java.text.DecimalFormat;
import javax.swing.DefaultListModel;

/**
 *
 * @author Usuario
 */
public class ModelListNumeros extends DefaultListModel<Float>{

    public ModelListNumeros() {
    }

    

    public void agregarListNumeros(ListaEnlazada<Float> lista) {
        
        NodoLista<Float> aux = lista.getCabecera();
        
        while (aux != null) {
            addElement(aux.getDato());

            aux = aux.getSiguiente();

        }

    }
    public void vaciar(){
       
        removeAllElements();
    }


    
}
