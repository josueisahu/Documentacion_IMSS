package com.example.ricardoluna.testsqlite;

/**
 * Created by RicardoLuna on 20/09/2016.
 */
public class detalleSwitcher {
    String numSerieSwit ,numero  ;
    int idSwitcher ,propiedad ;

    public detalleSwitcher(String numSerieSwit, String numero, int idSwitcher, int propiedad) {
        this.numSerieSwit = numSerieSwit;
        this.numero = numero;
        this.idSwitcher = idSwitcher;
        this.propiedad = propiedad;
    }

    public String getNumSerieSwit() {
        return numSerieSwit;
    }

    public void setNumSerieSwit(String numSerieSwit) {
        this.numSerieSwit = numSerieSwit;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getIdSwitcher() {
        return idSwitcher;
    }

    public void setIdSwitcher(int idSwitcher) {
        this.idSwitcher = idSwitcher;
    }

    public int getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(int propiedad) {
        this.propiedad = propiedad;
    }
}
