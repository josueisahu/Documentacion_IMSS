package com.example.ricardoluna.testsqlite;

/**
 * Created by RicardoLuna on 20/09/2016.
 */
public class Marcas {
    String  nombre;
    int idMarca;

    public Marcas(int idMarca, String nombre) {
        this.idMarca = idMarca;
        this.nombre = nombre;
    }
    public Marcas( ) {
    }

    public int getIdMarca() {
        return idMarca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

