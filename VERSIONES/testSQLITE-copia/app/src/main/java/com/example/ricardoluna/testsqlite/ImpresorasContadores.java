package com.example.ricardoluna.testsqlite;

/**
 * Created by RicardoLuna on 20/09/2016.
 */
public class ImpresorasContadores {
    String serie  ;
    int folio , idFotoconductor ,contador ;

    public ImpresorasContadores(String serie, int folio, int idFotoconductor, int contador) {
        this.serie = serie;
        this.folio = folio;
        this.idFotoconductor = idFotoconductor;
        this.contador = contador;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public int getIdFotoconductor() {
        return idFotoconductor;
    }

    public void setIdFotoconductor(int idFotoconductor) {
        this.idFotoconductor = idFotoconductor;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
}
