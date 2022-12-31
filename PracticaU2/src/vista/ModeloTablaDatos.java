/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.listas.ListaEnlazada;
import controlador.listas.NodoLista;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class ModeloTablaDatos {
    private modelo.Ejercicio2 listaGatos;

    public modelo.Ejercicio2 getListaGatos() {
        return listaGatos;
    }

    public void setListaGatos(modelo.Ejercicio2 listaGatos) {
        this.listaGatos = listaGatos;
    }
   

    
    
   public void llenarDatos(ListaEnlazada<modelo.Ejercicio2> listaGatos){
       listaGatos.insertar(new modelo.Ejercicio2(30, "Pedro Porro", "Blanco", 4.6f));
       listaGatos.insertar(new modelo.Ejercicio2(60, "Kiti", "Siames", 1.6f));
       listaGatos.insertar(new modelo.Ejercicio2(21, "Pancho", "Negro", 1.6f));
       listaGatos.insertar(new modelo.Ejercicio2(1, "Gato", "Negro", 3.6f));
       listaGatos.insertar(new modelo.Ejercicio2(50, "Gata", "Naranja", 4.0f));
       listaGatos.insertar(new modelo.Ejercicio2(98, "Juan", "Manchado", 4.5f));
       listaGatos.insertar(new modelo.Ejercicio2(120, "Rigoberto", "Asiatico", 5.5f));
       listaGatos.insertar(new modelo.Ejercicio2(45, "Pancracio", "Bengali", 1.0f));
       listaGatos.insertar(new modelo.Ejercicio2(3, "Toreto", "Griss", 5f));
       listaGatos.insertar(new modelo.Ejercicio2(5, "Huevo", "Plomo", 1.25f));
       listaGatos.insertar(new modelo.Ejercicio2(7, "Lewandoski", "Griss", 1.5f));
       listaGatos.insertar(new modelo.Ejercicio2(20, "Juve", "Naranja", 7f));
       listaGatos.insertar(new modelo.Ejercicio2(26, "Oblack", "Balines", 6.5f));
       listaGatos.insertar(new modelo.Ejercicio2(27, "Cubo", "Blanco", 3.5f));
       listaGatos.insertar(new modelo.Ejercicio2(19, "Triangulo", "Blanco", 4.5f));
       listaGatos.insertar(new modelo.Ejercicio2(18, "Joao", "Manchado", 4f));
       listaGatos.insertar(new modelo.Ejercicio2(15, "Tijera", "Persa", 3f));
       listaGatos.insertar(new modelo.Ejercicio2(12, "Michu", "Normal", 0.5f));
   }

   public void mostrar(JTable panelPersona, ListaEnlazada<modelo.Ejercicio2> listaGatos){
        DefaultTableModel modelo=new DefaultTableModel();
        
    //public Ejercicio2(Integer id, String nombre, String raza, Float edad) {
       
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Raza");
        modelo.addColumn("Edad");
        
        panelPersona.setModel(modelo);
        
        
        Object [] object= new Object[4];  
        if (listaGatos.estaVacia()) {
            System.out.println("esta vacia");
        }else{
            NodoLista<modelo.Ejercicio2> viajero;
            viajero=listaGatos.getCabecera();
            while (viajero!=null) {                
                System.out.println(viajero.getDato().toString());
                object[0]=viajero.getDato().getId();
                object[1]=viajero.getDato().getNombre();
                object[2]=viajero.getDato().getRaza();
                object[3]=viajero.getDato().getEdad();
                viajero=viajero.getSiguiente();
                modelo.addRow(object);
        }
        
        

        
        
        
    }
    

    
}
}
