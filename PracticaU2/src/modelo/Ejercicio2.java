/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Usuario
 */
public class Ejercicio2 {
    private Integer id;
    private String nombre;
    private String raza;
    private Float edad;

    public Ejercicio2() {
    }

    public Ejercicio2(Integer id, String nombre, String raza, Float edad) {
        this.id = id;
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Float getEdad() {
        return edad;
    }

    public void setEdad(Float edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Ejercicio2{" + "id=" + id + ", nombre=" + nombre + ", raza=" + raza + ", edad=" + edad + '}';
    }
    
    
    
    
}
