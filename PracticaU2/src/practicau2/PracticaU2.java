/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practicau2;

import controlador.listas.ListaEnlazada;
import modelo.Ejercicio2;

/**
 *
 * @author Usuario
 */
public class PracticaU2 {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
//        ListaEnlazada<Float> lista=new ListaEnlazada<>();
//        ListaEnlazada<Float> lista1=new ListaEnlazada<>();
//        
//        lista.llenarLista(20000);
//        lista.imprimirFloat();
//        lista.oredenarShell(1).imprimirFloat();
//        lista.quickShort1(1).imprimirFloat();

        ListaEnlazada<Ejercicio2> listaGatos=new ListaEnlazada<>();
                ListaEnlazada<Ejercicio2> listaGatos1=new ListaEnlazada<>();

        listaGatos.insertar(new Ejercicio2(1, "Pepe", "Blanco", 5.4f));
        listaGatos.insertar(new Ejercicio2(500, "Rambo", "Cafe", 8.2f));
        listaGatos.insertar(new Ejercicio2(9, "Goku", "Manchado", 6.7f));
        listaGatos.insertar(new Ejercicio2(8, "Goku", "Gris", 3.4f));
        listaGatos.insertar(new Ejercicio2(1, "Paco", "Cafe", 3.14f));
        listaGatos.imprimir();
//        listaGatos.burbuja("id", 1).imprimir();
//        listaGatos.buscar("id", 2).imprimir();
//    listaGatos.burbuja("nombre", 1).imprimir();
//    listaGatos.busquedaBinaria("nombre", "Paco").imprimir();
        listaGatos.order_Seleccion("id", 1).imprimir();
        listaGatos.busquedaBinariaLineaI("id", 1).imprimir();
        
    }
    
    
}
