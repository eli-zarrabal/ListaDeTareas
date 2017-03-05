package itsco.edu.listadetareas;

/**
 * Created by 75000 on 22/02/2017.
 */

public class Tarea {


    private String titulo;
    private String descripcion;
    private String fecha;


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString(){
        return this.titulo;

    }
}
