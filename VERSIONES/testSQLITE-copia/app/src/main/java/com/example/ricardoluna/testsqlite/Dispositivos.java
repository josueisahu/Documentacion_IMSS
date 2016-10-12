package com.example.ricardoluna.testsqlite;

/**
 * Created by RicardoLuna on 20/09/2016.
 */
public class Dispositivos {
    String nombreDispositivos ;
    int idDipositivo ;

    public Dispositivos(String nombreDispositivos, int idDipositivo) {
        this.nombreDispositivos = nombreDispositivos;
        this.idDipositivo = idDipositivo;
    }

    public String getNombreDispositivos() {
        return nombreDispositivos;
    }

    public void setNombreDispositivos(String nombreDispositivos) {
        this.nombreDispositivos = nombreDispositivos;
    }

    public int getIdDipositivo() {
        return idDipositivo;
    }

    public void setIdDipositivo(int idDipositivo) {
        this.idDipositivo = idDipositivo;
    }
}
