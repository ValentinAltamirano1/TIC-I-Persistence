package com.example.PersistanceApp.Reservas;

import com.example.PersistanceApp.Actividades.Actividades;
import com.example.PersistanceApp.Actividades.ActividadesKey;
import com.example.PersistanceApp.Empleados.Empleados;
import com.example.PersistanceApp.Horario.HorarioKey;
import com.example.PersistanceApp.Imagen.Imagenes;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.List;

@Embeddable
public class ReservasKey  implements Serializable { //se extendio actividades para que se pueda implementar el eliminar

    @ManyToOne
    @JoinColumn(name = "empleados_pasaporte")
    private Empleados empleados;

    private String fecha;

    private String horario;

    public ReservasKey() {
    }

    public ReservasKey(Empleados empleados, String fecha, String horario) {
        this.empleados = empleados;
        this.fecha = fecha;
        this.horario = horario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Empleados getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
    }

    @Override
    public String toString() {
        return "ReservasKey{" +
                "empleados=" + empleados +
                ", fecha='" + fecha + '\'' +
                ", horario='" + horario + '\'' +
                '}';
    }
}
