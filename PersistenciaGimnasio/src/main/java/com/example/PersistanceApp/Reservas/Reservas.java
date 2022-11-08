package com.example.PersistanceApp.Reservas;

import com.example.PersistanceApp.Actividades.Actividades;
import com.example.PersistanceApp.Empleados.Empleados;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Reservas {

    @OneToOne(orphanRemoval = true)
    @JoinColumns({
            @JoinColumn(name = "ACTIVIDADES_CENTROS_DEPORTIVOS_RUT", referencedColumnName = "CENTROS_DEPORTIVOS_RUT"),
            @JoinColumn(name = "ACTIVIDADES_NOMBRE", referencedColumnName = "NOMBRE"),
            @JoinColumn(name = "ACTIVIDADES_HORARIO", referencedColumnName = "HORARIO")
    })
    private Actividades actividades;


    @EmbeddedId
    private ReservasKey reservasKey;

    private boolean asistio;

    public Actividades getActividades() {
        return actividades;
    }

    public void setActividades(Actividades actividades) {
        this.actividades = actividades;
    }

    public Reservas() {
    }

    public Reservas(Actividades actividades, ReservasKey reservasKey, boolean asistio) {
        this.actividades = actividades;
        this.reservasKey = reservasKey;
        this.asistio = asistio;
    }


    public ReservasKey getReservasKey() {
        return reservasKey;
    }

    public void setReservasKey(ReservasKey reservasKey) {
        this.reservasKey = reservasKey;
    }

    public boolean isAsistio() {
        return asistio;
    }

    public void setAsistio(boolean asistio) {
        this.asistio = asistio;
    }

    @Override
    public String toString() {
        return "Reservas{" +
                "actividades=" + actividades +
                ", reservasKey=" + reservasKey +
                ", asistio=" + asistio +
                '}';
    }
}
