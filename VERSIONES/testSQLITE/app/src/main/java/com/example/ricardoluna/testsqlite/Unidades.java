package com.example.ricardoluna.testsqlite;

/**
 * Created by RicardoLuna on 20/09/2016.
 */
public class Unidades {
    String nombreModelo  ;
    int NumeroUnidadUni  ;

    public Unidades(String nombreModelo, int numeroUnidadUni) {
        this.nombreModelo = nombreModelo;
        NumeroUnidadUni = numeroUnidadUni;
    }

    public String getNombreModelo() {
        return nombreModelo;
    }

    public void setNombreModelo(String nombreModelo) {
        this.nombreModelo = nombreModelo;
    }

    public int getNumeroUnidadUni() {
        return NumeroUnidadUni;
    }

    public void setNumeroUnidadUni(int numeroUnidadUni) {
        NumeroUnidadUni = numeroUnidadUni;
    }
}
