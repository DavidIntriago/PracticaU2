/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.listas;

import controlador.listas.excepciones.atributoexception;
import controlador.listas.excepciones.listanullExcepction;
import controlador.listas.excepciones.tamanioNoEncontradaException;
import controlador.utiles.Utilidades;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.text.DecimalFormat;

/**
 *
 * @author Usuario
 */
public class ListaEnlazada<E> {

    private static Integer ASCENDENTE = 1;
    private static Integer DESCENDENTE = 2;
    private NodoLista<E> cabecera;
    private Integer size;

    public NodoLista<E> getCabecera() {
        return cabecera;
    }

    public void setCabecera(NodoLista<E> cabecera) {
        this.cabecera = cabecera;
    }

    public Integer getSize() {
//        this.size=tamanio();
        return size;
    }

    public void setSize(Integer size) {

        this.size = size;
    }

    public ListaEnlazada() {
        cabecera = null;
        size = 0;
    }

    public boolean estaVacia() {
        return cabecera == null;
    }

//    private Integer tamanio(){
//        Integer tamanio=0;
//        NodoLista<E> aux=cabecera;
//        while (aux != null) {
//            tamanio++;         
//            aux=aux.getSiguiente();
//        }
//        return tamanio;
//    }
    public void llenarLista(Integer limite) {
        for (int i = 0; i < limite; i++) {
            float nume1 = (float) Math.random() * 100;
            float nume = (float) Math.round(nume1 * 100) / 100;
            NodoLista<Float> nodo = new NodoLista<>(nume, null);
            if (estaVacia()) {
                this.cabecera = (NodoLista<E>) nodo;

            } else {
                NodoLista<E> aux = cabecera;
                while (aux.getSiguiente() != null) {
                    aux = aux.getSiguiente();
                }
                aux.setSiguiente((NodoLista<E>) nodo);

            }
            size++;
        }
    }

    public void insertar(E dato) {
        NodoLista<E> nodo = new NodoLista<>(dato, null);
        if (estaVacia()) {
            this.cabecera = nodo;

        } else {
            NodoLista<E> aux = cabecera;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nodo);

        }
        size++;

    }

    public void insertarCabecera(E dato) {

        if (estaVacia()) {
            insertar(dato);
        } else {
            NodoLista<E> nodo = new NodoLista<>(dato, null);
            nodo.setSiguiente(cabecera);
            cabecera = nodo;
            size++;
        }
    }

    public void insertarPosicion(E dato, Integer pos) throws tamanioNoEncontradaException {
        if (estaVacia()) {
            insertar(dato);
        } else if (pos >= 0 && pos < size) {
            if (pos == (size - 1)) {
                insertar(dato);
            } else if (pos == 0) {
                insertarCabecera(dato);
            } else {
                NodoLista<E> nodo = new NodoLista(dato, null);
                NodoLista<E> aux = cabecera;

                for (int i = 0; i < (pos - 1); i++) {
                    aux = aux.getSiguiente();
                }

                NodoLista<E> siguiente = aux.getSiguiente();
                aux.setSiguiente(nodo);
                nodo.setSiguiente(siguiente);
                size++;
            }
        } else {
            throw new tamanioNoEncontradaException();
        }

    }
    DecimalFormat formato1 = new DecimalFormat("#.00");

    public void imprimirFloat() {
        System.out.println("------------------Lista Enlazada---------------");
//        E[] matriz=toArray();
//        for (int i = 0; i < matriz.length; i++) {
//            System.out.println(formato1.format(matriz[i]));
//        }
        NodoLista<E> aux = cabecera;

        while (aux != null) {
            System.out.println(formato1.format(aux.getDato()) + "\t");
            aux = aux.getSiguiente();

        }

        System.out.println("...............................................");

    }

    public void imprimir() {

        System.out.println("------------------Lista Enlazada---------------");
        NodoLista<E> aux = cabecera;
        while (aux != null) {
            System.out.println(aux.getDato().toString() + "\t");
            aux = aux.getSiguiente();

        }
        System.out.println("...............................................");

    }

    public E obtener(Integer pos) throws listanullExcepction, tamanioNoEncontradaException {

        if (!estaVacia()) {
            E dato = null;
            if (pos >= 0 && pos < size) {
                if (pos == 0) {
                    dato = cabecera.getDato();

                } else {
                    NodoLista<E> aux = cabecera;
                    for (int i = 0; i < pos; i++) {
                        aux = aux.getSiguiente();
                    }
                    dato = aux.getDato();
                }
            } else {
                throw new tamanioNoEncontradaException();
            }
            return dato;
        } else {
            throw new listanullExcepction();
        }
//        return dato;
    }

    public E eliminar(Integer pos) throws listanullExcepction, tamanioNoEncontradaException {
        if (!estaVacia()) {
            E dato = null;
            if (pos >= 0 && pos < size) {
                if (pos == 0) {
                    dato = cabecera.getDato();
                    cabecera = cabecera.getSiguiente();
                    size--;

                } else {
                    NodoLista<E> aux = cabecera;
                    for (int i = 0; i < pos; i++) {
                        aux = aux.getSiguiente();
                    }
                    dato = aux.getDato();
                    NodoLista<E> proximo = aux.getSiguiente();
                    aux.setSiguiente(proximo.getSiguiente());
                    size--;
                }
            } else {
                throw new tamanioNoEncontradaException();
            }
            return dato;
        } else {
            throw new listanullExcepction();
        }

    }

    public E[] toArray() {
        //Class<E> clazz=cabecera.getDato().getClass();
        E[] matriz = null;
        if (this.size > 0) {
            matriz = (E[]) Array.newInstance(cabecera.getDato().getClass(), this.size);
            NodoLista<E> aux = cabecera;
            for (int i = 0; i < this.size; i++) {
                matriz[i] = aux.getDato();
                aux = aux.getSiguiente();
            }
        }
        return matriz;
    }

    public ListaEnlazada<E> toList(E[] matriz) {
        this.vaciar();
        for (int i = 0; i < matriz.length; i++) {
            this.insertar(matriz[i]);
        }
        return this;
    }

    public void vaciar() {
        this.cabecera = null;;
        this.size = 0;
    }

    public ListaEnlazada<E> burbuja(String atributo, Integer tipo) throws Exception {
        Class<E> clazz = null;
        E[] matriz = toArray();
        if (size > 0) {
            clazz = (Class<E>) cabecera.getDato().getClass();
            Boolean isObject = Utilidades.isObject(clazz);
            for (int i = matriz.length; i > 1; i--) {
                for (int j = 0; j < i - 1; j++) {
                    if (isObject) {
                        intercambioObjeto(j, matriz, clazz, tipo, atributo);
                    } else {
                        intercambioDato(j, matriz, clazz, tipo);
                    }
                }
            }
        }
        if (matriz != null) {
            toList(matriz);
        }
        return this;

    }

    public ListaEnlazada<E> metodoShell(int tipo) {
        Class<E> clazz = null;
        E[] matriz = toArray();
        if (size > 0) {
            clazz = (Class<E>) cabecera.getDato().getClass();
            Boolean isObject = Utilidades.isObject(clazz);
            int salto, i, aux;
            boolean cambio;
            for (salto = matriz.length / 2; salto != 0; salto /= 2) {
                cambio = true;
                while (cambio) {
                    cambio = false;
                    for (i = salto; i < matriz.length; i++) {
                        if (isObject) {

                        } else {
                            intercambioShell(matriz, i, salto, tipo, cambio);
                            cambio = true;
                        }
                    }

                }
            }
        }
        return this;
    }

    public ListaEnlazada<E> oredenarShell(int tipo) {
        E[] matriz = toArray();
        int intervalo, i, j, k;
        intervalo = matriz.length / 2;
        while (intervalo > 0) {
            for (i = intervalo; i < matriz.length; i++) {
                j = i - intervalo;
                while (j >= 0) {
                    k = j + intervalo;
                    if (tipo == ASCENDENTE) {
                        if ((Float) matriz[j] <= (Float) matriz[k]) {
                            j = -1;
                        } else {
                            intercambiarShell(matriz, j, j + 1);
                            j -= intervalo;
                        }
                    } else {

                        if ((Float) matriz[j] >= (Float) matriz[k]) {
                            j = -1;
                        } else {
                            intercambiarShell(matriz, j, j + 1);
                            j -= intervalo;
                        }
                    }
                }
            }
            intervalo = intervalo / 2;
        }
        ListaEnlazada<E> listaOrdenada = toList(matriz);
        return listaOrdenada;
    }
//    public ListaEnlazada<E> ordenarientoQuickshort(){
//        E[] matriz=toArray();
//        ordenarQuicksort(matriz, 0, matriz.length-1);
//        ListaEnlazada<E> listaOrdenada=toList(matriz);
//        return listaOrdenada;
//    }

    public ListaEnlazada<E> quickShort1(Integer tipo) {
        E[] matriz = toArray();
        int b = matriz.length - 1;
        ordenarQuicksort((Float[]) matriz, 0, b, tipo);
        ListaEnlazada<E> listaOrdenada = toList(matriz);
        return listaOrdenada;
    }

    public void ordenarQuicksort(Float[] matriz, Integer primero, Integer ultimo, Integer tipo) {
        int i, j;
        Float aux;
        Float pivot = matriz[primero];
        i = primero;
        j = ultimo;
        while (i < j) {
            if (tipo == ASCENDENTE) {
                while (matriz[i] <= pivot && i < j) {
                    i++;
                }
                while (matriz[j] > pivot) {
                    j--;
                }
                if (i < j) {
                    intercambiarShell((E[]) matriz, i, j);
                }
            } else {
                while (matriz[i] >= pivot && i < j) {
                    i++;
                }
                while (matriz[j] < pivot) {
                    j--;
                }
                if (i < j) {
                    intercambiarShell((E[]) matriz, i, j);
                }
            }

        }
        matriz[primero] = matriz[j];
        matriz[j] = pivot;
        if (primero < j - 1) {
            ordenarQuicksort(matriz, primero, j - 1, tipo);
        }
        if (j + 1 < ultimo) {
            ordenarQuicksort(matriz, j + 1, ultimo, tipo);
        }
    }

    public void intercambiarShell(E[] matriz, Integer i, Integer j) {
        E aux = matriz[i];
        matriz[i] = matriz[j];
        matriz[j] = (E) aux;
    }

//    public ListaEnlazada<E> oredenarShells(int tipo) {
//        E[] matriz=toArray();
//
//        int salto, i;
//        Object aux;
//        boolean cambio;
//        for (salto = matriz.length / 2; salto != 0; salto /= 2) {
//            cambio = true;
//            while (cambio) {
//                cambio = false;
//                for (i = salto; i < matriz.length; i++) {
//                    if ((Float)matriz[i - salto] > (Float)matriz[i]) {
//                        aux = matriz[i];
//                        matriz[i] = matriz[i - salto];
//                        matriz[i - salto] = (E) aux;
//                        cambio = true;
//
//                    }
//                }
//
//            }
//
//        }
//        ListaEnlazada<E> listaOrdenada=toList(matriz);
//        return listaOrdenada;
//        
//      
//        
//    }
    public void intercambioShell(E[] matriz1, Integer i, Integer salto, Integer tipo, Boolean cambio) {
        Float aux;
        Class clazz = matriz1[0].getClass();
        if (Utilidades.isNumbre(clazz)) {
            if (tipo == ASCENDENTE) {
                if ((Float) matriz1[i - salto] > (Float) matriz1[i]) {
                    aux = (Float) matriz1[i];
                    matriz1[i] = matriz1[i - salto];
                    matriz1[i - salto] = (E) aux;
                    cambio = true;

                }
            } else {
                if ((Float) matriz1[i - salto] < (Float) matriz1[i]) {
                    aux = (Float) matriz1[i];
                    matriz1[i] = matriz1[i - salto];
                    matriz1[i - salto] = (E) aux;
                    cambio = true;
                }

            }

        }
    }
//    
//    public ListaEnlazada<E> ordenarShell(int tipo){
//        E[] matriz = toArray();
//        int salto, aux, i;
//        boolean cambio;
//        for (salto = matriz.length/2 ;salto!=0 ; salto/=2) {
//            cambio=true;
//            while (cambio) {                
//                cambio=false;
//                for (i = salto; i < matriz.length; i++) {
//                    if ((Float[])matriz[i-salto]>(Float[])matriz[i]) {
//                        
//                    }
//                }
//            }
//            
//        }
//    }
//     INTERCAMBIO SOLO PARA DATOS SIMPLES, NO OBJETOSSSSS

    private void intercambioDato(int j, E[] matriz, Class clazz, Integer tipo) {
        E auxJ = matriz[j];
        E auxJ1 = matriz[j + 1];
        intercambio(j, matriz, auxJ, auxJ1, tipo);
    }

    private void intercambioObjeto(int j, E[] matriz, Class clazz, Integer tipo, String atributo) throws Exception {
        E auxJ = matriz[j];
        E auxJ1 = matriz[j + 1];
        Field field = Utilidades.obtenerAtributo(clazz, atributo);
        if (field == null) {
            throw new atributoexception();
        }
        field.setAccessible(true);
        Object a = field.get(auxJ);
        Object b = field.get(auxJ1);
        intercambio(j, matriz, a, b, tipo);
    }

    public ListaEnlazada(NodoLista<E> cabecera, Integer size) {
        this.cabecera = cabecera;
        this.size = size;
    }

    private void intercambio(int j, E[] matriz, Object auxJ, Object auxJ1, Integer tipo) {
        Class clazz = auxJ.getClass();
        E a = matriz[j];
        E b = matriz[j + 1];
        if (Utilidades.isNumbre(clazz)) {
            if (tipo == DESCENDENTE) {
                if (((Number) auxJ).doubleValue() < ((Number) auxJ1).doubleValue()) {
                    matriz[j] = b;
                    matriz[j + 1] = a;
                }
            } else {
                if (((Number) auxJ).doubleValue() > ((Number) auxJ1).doubleValue()) {
                    matriz[j] = b;
                    matriz[j + 1] = a;
                }
            }

        }
        if (Utilidades.isString(clazz)) {
            if (tipo == DESCENDENTE) {
                if (auxJ.toString().toLowerCase().compareTo(auxJ1.toString().toLowerCase()) < 0) {
                    matriz[j] = b;
                    matriz[j + 1] = a;
                }
            } else {
                if (auxJ.toString().toLowerCase().compareTo(auxJ1.toString().toLowerCase()) > 0) {
                    matriz[j] = b;
                    matriz[j + 1] = a;
                }
            }
        }
    }

//SELECCIONAR    
    public ListaEnlazada<E> order_Seleccion(String atributo, Integer tipo) throws Exception {
        Class<E> clazz = null;
        E[] matriz = toArray();
        if (size > 0) {
            clazz = (Class<E>) cabecera.getDato().getClass();
            Boolean isObject = Utilidades.isObject(clazz);
            //ALGORITOMO SELECCION
            Integer i, j, k = 0;
            Integer n = matriz.length;
            E t = null;
            for (i = 0; i < n - 1; i++) {
                k = i;
                t = matriz[i];
                for (j = i + 1; j < n; j++) {
                    E auxj1 = matriz[j];
                    Object[] aux = null;
                    if (isObject) {
                        aux = evaluarCambioObjeto(t, auxj1, j, tipo, clazz, atributo);
                    } else {
                        aux = evaluarCambioDato(t, auxj1, j, tipo);
                    }
                    if (aux[0] != null) {
                        t = (E) aux[0];
                        k = (Integer) aux[1];
                    }
                }
                matriz[k] = matriz[i];
                matriz[i] = t;
            }
        }
        if (matriz != null) {
            toList(matriz);
        }
        return this;

    }

    private Object[] evaluarCambioDato(E auxJ, E auxJ1, Integer j, Integer tipo) {
        return evaluarCambio(auxJ, auxJ1, auxJ1, j, tipo);
    }

    private Object[] evaluarCambioObjeto(E auxJ, E auxJ1, Integer j, Integer tipo, Class clazz, String atributo) throws atributoexception, Exception {
        Field field = Utilidades.obtenerAtributo(clazz, atributo);
        if (field == null) {
            throw new atributoexception();
        } else {
            field.setAccessible(true);
            Object a = field.get(auxJ);
            Object b = field.get(auxJ1);
            return evaluarCambio(a, b, auxJ1, j, tipo);
        }

    }

    private Object[] evaluarCambio(Object auxJ, Object auxJ1, E dato, Integer j, Integer tipo) {

        Object[] aux = new Object[2];
        Class clazz = auxJ.getClass();
        if (Utilidades.isNumbre(clazz)) {
            if (tipo == DESCENDENTE) {
                if ((((Number) auxJ)).doubleValue() < (((Number) auxJ1)).doubleValue()) {
                    aux[0] = dato;
                    aux[1] = j;
                }
            } else {
                if ((((Number) auxJ)).doubleValue() > (((Number) auxJ1)).doubleValue()) {
                    aux[0] = dato;
                    aux[1] = j;
                }
            }

        }
        if (Utilidades.isString(clazz)) {
            if (tipo == DESCENDENTE) {
                if (auxJ.toString().toLowerCase().compareTo(auxJ1.toString().toLowerCase()) < 0) {
                    aux[0] = dato;
                    aux[1] = j;
                }
            } else {
                if (auxJ.toString().toLowerCase().compareTo(auxJ1.toString().toLowerCase()) > 0) {
                    aux[0] = dato;
                    aux[1] = j;
                }
            }
        }
        return aux;
    }

    //BUSQUEDA
    public ListaEnlazada<E> busquedaBinariaLineal(String atributo, Object dato) throws Exception {
        Class<E> clazz = null;
        ListaEnlazada<E> result = new ListaEnlazada<>();
        if (size > 0) {
            E[] matriz = toArray();

            clazz = (Class<E>) cabecera.getDato().getClass();
            Boolean isObject = Utilidades.isObject(clazz);

            for (int i = 0; i < matriz.length; i++) {
                if (isObject) {
                    Boolean band = evaluarBusquedaObjeto(matriz[i], dato, clazz, atributo);
                    if (band) {
                        result.insertar(matriz[i]);
                    }
                } else {
                    //PARA DATOS PRIMITIVOS
                    Boolean band = buscarPosicion(matriz[i], dato);
                    if (band) {
                        result.insertar(matriz[i]);
                    }
                }
            }
        }

        return result;

    }

    public ListaEnlazada<E> busquedaBinaria(String atributo, Object dato) throws Exception {
        Class<E> clazz = null;
        ListaEnlazada<E> result = new ListaEnlazada<>();
        if (size > 0) {
            E[] matriz = toArray();

            clazz = (Class<E>) cabecera.getDato().getClass();
            Boolean isObject = Utilidades.isObject(clazz);
            int central, bajo, alto;
            E valorCentral;
            bajo = 0;
            alto = matriz.length - 1;
            while (bajo <= alto) {
                central = (bajo + alto) / 2;
                valorCentral = matriz[central];
                if (isObject) {
                    Field field = Utilidades.obtenerAtributo(clazz, atributo);
                    if (field == null) {
                        throw new atributoexception();
                    } else {
                        field.setAccessible(true);
                        Object a = field.get(matriz[central]);
                        if (Utilidades.isNumbre(dato.getClass())) {

                            if ((((Number) a)).doubleValue() == ((Number) dato).doubleValue()) {
                                result.insertar(matriz[central]);
                                return result;
                            } else if ((((Number) a)).doubleValue() < ((Number) dato).doubleValue()) {
                                alto = central - 1;
                            } else {
                                bajo = central + 1;
                            }
                        } else {
                            if (Utilidades.isString(dato.getClass())) {
                                if (a.toString().toLowerCase().equalsIgnoreCase(dato.toString().toLowerCase())) {
                                    result.insertar(matriz[central]);
                                    return result;
                                } else {
                                    if (a.toString().toLowerCase().compareTo(dato.toString().toLowerCase()) > 0) {
                                        alto = central - 1;
                                    } else {
                                        bajo = central + 1;
                                    }
                                }
                            }
                        }
                    }

                }
            }
        }

        return result;
    }

    public ListaEnlazada<E> busquedaBinariaLineaI(String atributo, Object dato) throws Exception {
        Class<E> clazz = null;
        ListaEnlazada<E> result = new ListaEnlazada<>();
        if (size > 0) {
            E[] matriz = toArray();

            clazz = (Class<E>) cabecera.getDato().getClass();
            Boolean isObject = Utilidades.isObject(clazz);
            int central, bajo, alto;
            E valorCentral;
            bajo = 0;
            alto = matriz.length - 1;
            central = (bajo + alto) / 2;
            valorCentral = matriz[central];
            if (isObject) {
                Field field = Utilidades.obtenerAtributo(clazz, atributo);
                if (field == null) {
                    throw new atributoexception();
                } else {
                    field.setAccessible(true);
                    Object a = field.get(matriz[central]);
                    if (Utilidades.isNumbre(dato.getClass())) {

                        if ((((Number) a)).doubleValue() == ((Number) dato).doubleValue()) {
                            result.insertar(matriz[central]);

                            if ((((Number) a)).doubleValue() > ((Number) dato).doubleValue()) {
                                Integer aux = central - 1;
                                for (int i = 0; i < aux; i++) {
                                    Boolean band = buscarPosicion(dato, a);
                                    if (band) {
                                        result.insertar(matriz[i]);
                                    }
                                }
                            } else {
                                bajo = central + 1;
                                for (int i = bajo; bajo < matriz.length; bajo++) {
                                    Boolean band = buscarPosicion(dato, a);
                                    if (band) {
                                        result.insertar(matriz[i]);
                                    }
                                }
                            }
                        }
                        return result;
                    } else {
                        if (Utilidades.isString(dato.getClass())) {
                            if (a.toString().toLowerCase().equalsIgnoreCase(dato.toString().toLowerCase())) {
                                result.insertar(matriz[central]);
                                return result;
                            } else {
                                if (a.toString().toLowerCase().compareTo(dato.toString().toLowerCase()) > 0) {
                                    alto = central - 1;
                                    Integer aux = central - 1;
                                for (int i = 0; i < aux; i++) {
                                    Boolean band = buscarPosicion(dato, a);
                                    if (band) {
                                        result.insertar(matriz[i]);
                                    }
                                }
                                } else {
                                    bajo = central + 1;
                                    Integer aux = central - 1;
                                for (int i = 0; i < aux; i++) {
                                    Boolean band = buscarPosicion(dato, a);
                                    if (band) {
                                        result.insertar(matriz[i]);
                                    }
                                }
                                }
                            }
                        }
                    }
                }

            }
        }

        return result;
    }

    private Boolean buscarPosicionBinaria(Object datomatriz, Object busqueda) {
        //Falta implementar mas datos
        if (Utilidades.isNumbre(busqueda.getClass())) {
            if ((((Number) datomatriz)).doubleValue() == ((Number) busqueda).doubleValue()) {
                return true;
            }
        } else if (Utilidades.isString(busqueda.getClass())) {
            if (datomatriz.toString().toLowerCase().startsWith(busqueda.toString().toLowerCase())
                    || datomatriz.toString().toLowerCase().endsWith(busqueda.toString().toLowerCase())
                    || datomatriz.toString().toLowerCase().equalsIgnoreCase(busqueda.toString().toLowerCase())
                    || datomatriz.toString().toLowerCase().contains(busqueda.toString().toLowerCase())) {
                return true;
            }
        }

        return false;

    }

    private Boolean buscarPosicion(Object datomatriz, Object busqueda) {
        //Falta implementar mas datos
        if (Utilidades.isNumbre(busqueda.getClass())) {
            if ((((Number) datomatriz)).doubleValue() == ((Number) busqueda).doubleValue()) {
                return true;
            }
        } else if (Utilidades.isString(busqueda.getClass())) {
            if (datomatriz.toString().toLowerCase().startsWith(busqueda.toString().toLowerCase())
                    || datomatriz.toString().toLowerCase().endsWith(busqueda.toString().toLowerCase())
                    || datomatriz.toString().toLowerCase().equalsIgnoreCase(busqueda.toString().toLowerCase())
                    || datomatriz.toString().toLowerCase().contains(busqueda.toString().toLowerCase())) {
                return true;
            }
        }

        return false;

    }

    private Boolean evaluarBusquedaObjeto(E aux, Object dato, Class clazz, String atributo) throws atributoexception, Exception {
        Field field = Utilidades.obtenerAtributo(clazz, atributo);
        if (field == null) {
            throw new atributoexception();
        } else {
            field.setAccessible(true);
            Object a = field.get(aux);
            return buscarPosicion(a, dato);
        }

    }

    private Boolean evaluarBusquedaObjetoBinaria(E aux, Object dato, Class clazz, String atributo) throws atributoexception, Exception {
        Field field = Utilidades.obtenerAtributo(clazz, atributo);
        if (field == null) {
            throw new atributoexception();
        } else {
            field.setAccessible(true);
            Object a = field.get(aux);
            return buscarPosicionBinaria(a, dato);
        }

    }
}
