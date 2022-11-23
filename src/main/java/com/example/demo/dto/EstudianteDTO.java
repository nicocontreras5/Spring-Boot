package com.example.demo.dto;

import javax.persistence.Column;
import javax.persistence.Id;

public class EstudianteDTO {
    private int DNI;

    private String nombre;

    private String apellido;

    private int edad;

    private String genero;

    private String ciudad;

    private int num_libreta;

    public EstudianteDTO(int DNI, String nombre, String apellido, int edad, String genero, String ciudad, int num_libreta) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.ciudad = ciudad;
        this.num_libreta = num_libreta;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getNum_libreta() {
        return num_libreta;
    }

    public void setNum_libreta(int num_libreta) {
        this.num_libreta = num_libreta;
    }
}
