package com.example.ricardoluna.testsqlite;

/**
 * Created by RicardoLuna on 20/09/2016.
 */
public class detalleEquipos {
    String  numSerieEquipos ,ipDetaEquipo , macaddress,hostDetaEquipo ,
            observacionesDetaEquipo ,extensionDetaEquipo ,matricula ,nombreDetaEquipo ,
            apellidopaterno ,apellidomaterno ,puestoDetaEquipo ,observacionImpresora   ;
    int idDetalleEquipo ,idAreaDepUnidFK,impresora  ;

    public detalleEquipos(String numSerieEquipos, String ipDetaEquipo, String macaddress, String hostDetaEquipo, String observacionesDetaEquipo,
                          String extensionDetaEquipo, String matricula, String nombreDetaEquipo, String apellidopaterno,
                          String apellidomaterno, String puestoDetaEquipo, String observacionImpresora, int idDetalleEquipo,
                          int idAreaDepUnidFK, int impresora) {
        this.numSerieEquipos = numSerieEquipos;
        this.ipDetaEquipo = ipDetaEquipo;
        this.macaddress = macaddress;
        this.hostDetaEquipo = hostDetaEquipo;
        this.observacionesDetaEquipo = observacionesDetaEquipo;
        this.extensionDetaEquipo = extensionDetaEquipo;
        this.matricula = matricula;
        this.nombreDetaEquipo = nombreDetaEquipo;
        this.apellidopaterno = apellidopaterno;
        this.apellidomaterno = apellidomaterno;
        this.puestoDetaEquipo = puestoDetaEquipo;
        this.observacionImpresora = observacionImpresora;
        this.idDetalleEquipo = idDetalleEquipo;
        this.idAreaDepUnidFK = idAreaDepUnidFK;
        this.impresora = impresora;
    }

    public String getNumSerieEquipos() {
        return numSerieEquipos;
    }

    public void setNumSerieEquipos(String numSerieEquipos) {
        this.numSerieEquipos = numSerieEquipos;
    }

    public String getIpDetaEquipo() {
        return ipDetaEquipo;
    }

    public void setIpDetaEquipo(String ipDetaEquipo) {
        this.ipDetaEquipo = ipDetaEquipo;
    }

    public String getMacaddress() {
        return macaddress;
    }

    public void setMacaddress(String macaddress) {
        this.macaddress = macaddress;
    }

    public String getHostDetaEquipo() {
        return hostDetaEquipo;
    }

    public void setHostDetaEquipo(String hostDetaEquipo) {
        this.hostDetaEquipo = hostDetaEquipo;
    }

    public String getObservacionesDetaEquipo() {
        return observacionesDetaEquipo;
    }

    public void setObservacionesDetaEquipo(String observacionesDetaEquipo) {
        this.observacionesDetaEquipo = observacionesDetaEquipo;
    }

    public String getExtensionDetaEquipo() {
        return extensionDetaEquipo;
    }

    public void setExtensionDetaEquipo(String extensionDetaEquipo) {
        this.extensionDetaEquipo = extensionDetaEquipo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombreDetaEquipo() {
        return nombreDetaEquipo;
    }

    public void setNombreDetaEquipo(String nombreDetaEquipo) {
        this.nombreDetaEquipo = nombreDetaEquipo;
    }

    public String getApellidopaterno() {
        return apellidopaterno;
    }

    public void setApellidopaterno(String apellidopaterno) {
        this.apellidopaterno = apellidopaterno;
    }

    public String getApellidomaterno() {
        return apellidomaterno;
    }

    public void setApellidomaterno(String apellidomaterno) {
        this.apellidomaterno = apellidomaterno;
    }

    public String getPuestoDetaEquipo() {
        return puestoDetaEquipo;
    }

    public void setPuestoDetaEquipo(String puestoDetaEquipo) {
        this.puestoDetaEquipo = puestoDetaEquipo;
    }

    public String getObservacionImpresora() {
        return observacionImpresora;
    }

    public void setObservacionImpresora(String observacionImpresora) {
        this.observacionImpresora = observacionImpresora;
    }

    public int getIdDetalleEquipo() {
        return idDetalleEquipo;
    }

    public void setIdDetalleEquipo(int idDetalleEquipo) {
        this.idDetalleEquipo = idDetalleEquipo;
    }

    public int getIdAreaDepUnidFK() {
        return idAreaDepUnidFK;
    }

    public void setIdAreaDepUnidFK(int idAreaDepUnidFK) {
        this.idAreaDepUnidFK = idAreaDepUnidFK;
    }

    public int getImpresora() {
        return impresora;
    }

    public void setImpresora(int impresora) {
        this.impresora = impresora;
    }
}
