package com.example.PersistanceApp.Reservas;

import com.example.PersistanceApp.Actividades.Actividades;
import com.example.PersistanceApp.Empleados.Empleados;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class ReservasKey extends Actividades implements Serializable { //se extendio actividades para que se pueda implementar el eliminar

    @ManyToOne
    @JoinColumn(name = "empleados_pasaporte")
    private Empleados empleados;

    public ReservasKey() {
    }

    public ReservasKey(Empleados empleados) {
        this.empleados = empleados;
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
                '}';
    }
}
