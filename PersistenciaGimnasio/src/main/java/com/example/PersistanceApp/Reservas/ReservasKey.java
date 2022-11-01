package com.example.PersistanceApp.Reservas;

import com.example.PersistanceApp.Empleados.Empleados;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class ReservasKey implements Serializable {

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
