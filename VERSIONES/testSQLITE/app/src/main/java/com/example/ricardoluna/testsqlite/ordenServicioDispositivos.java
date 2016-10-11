package com.example.ricardoluna.testsqlite;

/**
 * Created by RicardoLuna on 20/09/2016.
 */
public class ordenServicioDispositivos {
    String fecha ,numSerie,piso ,extension ,nombre ,apellidoM ,apellidoP ,puesto ,observaciones ,idInstaladorFK ,area ,encargado ,host ,ip,
            tipoRack ,fechaActualizacion  ;
    int folioOrdenServicio,tipo ,matriculaFK ,NumeroUnidad ,CodDepartamento ,tipoUbicacion ,statusEquipo  ;

    public ordenServicioDispositivos(String fecha, String numSerie, String piso, String extension, String nombre, String apellidoM, String apellidoP,
                                     String puesto, String observaciones, String idInstaladorFK, String area, String encargado, String host, String ip, String tipoRack,
                                     String fechaActualizacion, int folioOrdenServicio, int tipo, int matriculaFK, int numeroUnidad, int codDepartamento,
                                     int tipoUbicacion, int statusEquipo) {
        this.fecha = fecha;
        this.numSerie = numSerie;
        this.piso = piso;
        this.extension = extension;
        this.nombre = nombre;
        this.apellidoM = apellidoM;
        this.apellidoP = apellidoP;
        this.puesto = puesto;
        this.observaciones = observaciones;
        this.idInstaladorFK = idInstaladorFK;
        this.area = area;
        this.encargado = encargado;
        this.host = host;
        this.ip = ip;
        this.tipoRack = tipoRack;
        this.fechaActualizacion = fechaActualizacion;
        this.folioOrdenServicio = folioOrdenServicio;
        this.tipo = tipo;
        this.matriculaFK = matriculaFK;
        NumeroUnidad = numeroUnidad;
        CodDepartamento = codDepartamento;
        this.tipoUbicacion = tipoUbicacion;
        this.statusEquipo = statusEquipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getIdInstaladorFK() {
        return idInstaladorFK;
    }

    public void setIdInstaladorFK(String idInstaladorFK) {
        this.idInstaladorFK = idInstaladorFK;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getTipoRack() {
        return tipoRack;
    }

    public void setTipoRack(String tipoRack) {
        this.tipoRack = tipoRack;
    }

    public String getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(String fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public int getFolioOrdenServicio() {
        return folioOrdenServicio;
    }

    public void setFolioOrdenServicio(int folioOrdenServicio) {
        this.folioOrdenServicio = folioOrdenServicio;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getMatriculaFK() {
        return matriculaFK;
    }

    public void setMatriculaFK(int matriculaFK) {
        this.matriculaFK = matriculaFK;
    }

    public int getNumeroUnidad() {
        return NumeroUnidad;
    }

    public void setNumeroUnidad(int numeroUnidad) {
        NumeroUnidad = numeroUnidad;
    }

    public int getCodDepartamento() {
        return CodDepartamento;
    }

    public void setCodDepartamento(int codDepartamento) {
        CodDepartamento = codDepartamento;
    }

    public int getTipoUbicacion() {
        return tipoUbicacion;
    }

    public void setTipoUbicacion(int tipoUbicacion) {
        this.tipoUbicacion = tipoUbicacion;
    }

    public int getStatusEquipo() {
        return statusEquipo;
    }

    public void setStatusEquipo(int statusEquipo) {
        this.statusEquipo = statusEquipo;
    }
}
