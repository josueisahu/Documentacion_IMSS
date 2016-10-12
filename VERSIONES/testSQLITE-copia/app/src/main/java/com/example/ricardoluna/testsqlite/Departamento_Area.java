package com.example.ricardoluna.testsqlite;

/**
 * Created by RicardoLuna on 20/09/2016.
 */
public class Departamento_Area {
    String areaDepAr  ;
    int idAreaDepUnid , NumeroUnidadFK , CodDepartamentoFK  ;

    public Departamento_Area(String areaDepAr, int idAreaDepUnid, int numeroUnidadFK, int codDepartamentoFK) {
        this.areaDepAr = areaDepAr;
        this.idAreaDepUnid = idAreaDepUnid;
        NumeroUnidadFK = numeroUnidadFK;
        CodDepartamentoFK = codDepartamentoFK;
    }

    public String getAreaDepAr() {
        return areaDepAr;
    }

    public void setAreaDepAr(String areaDepAr) {
        this.areaDepAr = areaDepAr;
    }

    public int getIdAreaDepUnid() {
        return idAreaDepUnid;
    }

    public void setIdAreaDepUnid(int idAreaDepUnid) {
        this.idAreaDepUnid = idAreaDepUnid;
    }

    public int getNumeroUnidadFK() {
        return NumeroUnidadFK;
    }

    public void setNumeroUnidadFK(int numeroUnidadFK) {
        NumeroUnidadFK = numeroUnidadFK;
    }

    public int getCodDepartamentoFK() {
        return CodDepartamentoFK;
    }

    public void setCodDepartamentoFK(int codDepartamentoFK) {
        CodDepartamentoFK = codDepartamentoFK;
    }
}
