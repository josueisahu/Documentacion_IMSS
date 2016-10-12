package com.example.ricardoluna.testsqlite;

/**
 * Created by RicardoLuna on 20/09/2016.
 */
public class Departamentos {
    String DescripcionDepa   ;
    int CodDepartamentoDepa ;

    public Departamentos(String descripcionDepa, int codDepartamentoDepa) {
        DescripcionDepa = descripcionDepa;
        CodDepartamentoDepa = codDepartamentoDepa;
    }

    public String getDescripcionDepa() {
        return DescripcionDepa;
    }

    public void setDescripcionDepa(String descripcionDepa) {
        DescripcionDepa = descripcionDepa;
    }

    public int getCodDepartamentoDepa() {
        return CodDepartamentoDepa;
    }

    public void setCodDepartamentoDepa(int codDepartamentoDepa) {
        CodDepartamentoDepa = codDepartamentoDepa;
    }
}
