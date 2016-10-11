package com.example.ricardoluna.testsqlite;

/**
 * Created by RicardoLuna on 20/09/2016.
 */
public class Equipos {
    String numSerieEqui ,numeroInventario  ;
    int idModeloFK ,status;

    public Equipos(String numSerieEqui, String numeroInventario, int idModeloFK, int status) {
        this.numSerieEqui = numSerieEqui;
        this.numeroInventario = numeroInventario;
        this.idModeloFK = idModeloFK;
        this.status = status;
    }

    public String getNumSerieEqui() {
        return numSerieEqui;
    }

    public void setNumSerieEqui(String numSerieEqui) {
        this.numSerieEqui = numSerieEqui;
    }

    public String getNumeroInventario() {
        return numeroInventario;
    }

    public void setNumeroInventario(String numeroInventario) {
        this.numeroInventario = numeroInventario;
    }

    public int getIdModeloFK() {
        return idModeloFK;
    }

    public void setIdModeloFK(int idModeloFK) {
        this.idModeloFK = idModeloFK;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
