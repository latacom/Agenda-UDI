package udi.agenda.Domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Tarea {
    private int id;
    private String nombre;
    private String descripcion;
    private Date fecha;
    private boolean estado;
    private List<Subtarea> listsubtarea;
    private String horaInicio;
    private String horaFin;

    public Tarea(int id, String nombre, String descripcion, Date fecha, boolean estado, List<Subtarea> subtarea, String horaInicio, String horaFin) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.estado = estado;
        this.listsubtarea = subtarea;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }
    public Tarea(){

    }
    public boolean SubTareasFinalizadas(){
        int cont =0;
        for (int i = 0; i <listsubtarea.size() ; i++) {
            if(listsubtarea.get(i).getEstado()==false){
                cont++;
            }
        }
        if(cont==listsubtarea.size()){
            estado = false;
            return true;
        }else{
            return  false;
        }
    }
    public String getMes(){
        String input = String.valueOf(fecha.getMonth());

        SimpleDateFormat df = new SimpleDateFormat("MM",new Locale("es","VE"));
        DateFormat df5 = new SimpleDateFormat("dd MMM",new Locale("es","VE"));
        String date = "";
        try{
            date = df5.format(df.parse(input));
        }catch(ParseException pe){
            pe.printStackTrace();
        }

        return date;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public List<Subtarea> getSubtarea() {
        return listsubtarea;
    }

    public void setSubtarea(List<Subtarea> subtarea) {
        this.listsubtarea = subtarea;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }
}
