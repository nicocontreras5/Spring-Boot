package com.example.demo.dto;

public class CarreraDTO {
    private String name;
    private int id;
    private int duracion;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public CarreraDTO(String name, int id, int duracion) {
        this.name = name;
        this.id = id;
        this.duracion = duracion;
    }
}
