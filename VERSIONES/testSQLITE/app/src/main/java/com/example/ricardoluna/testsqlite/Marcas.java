package com.example.ricardoluna.testsqlite;

/**
 * Created by RicardoLuna on 20/09/2016.
 */
public class Marcas {
    String  nombre;
    int clave;

    public Marcas(int idMarca, String nombre) {
        this.clave = idMarca;
        this.nombre = nombre;
    }
    public Marcas( ) {
    }

    public int getIdMarca() {
        return clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setIdMarca(int idMarca) {
        this.clave = idMarca;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

