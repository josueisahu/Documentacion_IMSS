package com.example.ricardoluna.testsqlite;

/**
 * Created by RicardoLuna on 20/09/2016.
 */
public class FotoConductores {
    String descripcionFot ,rendimiento  ;
    int id  ;

    public FotoConductores(String descripcionFot, String rendimiento, int id) {
        this.descripcionFot = descripcionFot;
        this.rendimiento = rendimiento;
        this.id = id;
    }

    public String getDescripcionFot() {
        return descripcionFot;
    }

    public void setDescripcionFot(String descripcionFot) {
        this.descripcionFot = descripcionFot;
    }

    public String getRendimiento() {
        return rendimiento;
    }

    public void setRendimiento(String rendimiento) {
        this.rendimiento = rendimiento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
