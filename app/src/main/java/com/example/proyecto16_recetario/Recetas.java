package com.example.proyecto16_recetario;

import java.io.Serializable;
import java.util.ArrayList;

public class Recetas implements Serializable {

    private String nombre;
    private String categoria; // platoFuerte, postre, bebida
    private int imagen; // recurso drawable
    private ArrayList<String[]> ingredientes; // [0] = nombre, [1] = cantidad
    private ArrayList<String> pasos; // lista de instrucciones

    public Recetas(String nombre, String categoria, int imagen,
                  ArrayList<String[]> ingredientes, ArrayList<String> pasos) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.imagen = imagen;
        this.ingredientes = ingredientes;
        this.pasos = pasos;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getImagen() {
        return imagen;
    }

    public ArrayList<String[]> getIngredientes() {
        return ingredientes;
    }

    public ArrayList<String> getPasos() {
        return pasos;
    }

    // Setters si necesitas modificar después
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public void setIngredientes(ArrayList<String[]> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public void setPasos(ArrayList<String> pasos) {
        this.pasos = pasos;
    }
}
