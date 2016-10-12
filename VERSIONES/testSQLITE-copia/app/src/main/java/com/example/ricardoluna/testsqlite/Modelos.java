package com.example.ricardoluna.testsqlite;

/**
 * Created by RicardoLuna on 20/09/2016.
 */
public class Modelos {
    String nombreModelo ;
    int idModelo, idDispositivoFK, idMarcaFK ;

    public Modelos(String nombreModelo, int idModelo, int idDispositivoFK, int idMarcaFK) {
        this.nombreModelo = nombreModelo;
        this.idModelo = idModelo;
        this.idDispositivoFK = idDispositivoFK;
        this.idMarcaFK = idMarcaFK;

    }

    public String getNombreModelo() {
        return nombreModelo;
    }

    public void setNombreModelo(String nombreModelo) {
        this.nombreModelo = nombreModelo;
    }

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    public int getIdDispositivoFK() {
        return idDispositivoFK;
    }

    public void setIdDispositivoFK(int idDispositivoFK) {
        this.idDispositivoFK = idDispositivoFK;
    }

    public int getIdMarcaFK() {
        return idMarcaFK;
    }

    public void setIdMarcaFK(int idMarcaFK) {
        this.idMarcaFK = idMarcaFK;
    }
}
