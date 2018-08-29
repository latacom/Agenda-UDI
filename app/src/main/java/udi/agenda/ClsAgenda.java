package udi.agenda;

import java.util.Date;

public class ClsAgenda {
    private String Nombre;
    private String Descripcion;
    private boolean Estado;
    private String  Fecha;

    public ClsAgenda(String nombre, String descripcion, String fecha) {
        Nombre = nombre;
        Descripcion = descripcion;
        Fecha = fecha;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean estado) {
        Estado = estado;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }
}
