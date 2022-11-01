package com.example.PersistanceApp.Reservas;

import com.example.PersistanceApp.Actividades.Actividades;
import com.example.PersistanceApp.Empleados.Empleados;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Reservas {

    @OneToOne
    @JoinColumns({
            @JoinColumn(name = "actividades_centros_deportivos_rut", referencedColumnName = "centros_deportivos_rut"),
            @JoinColumn(name = "actividades_nombre", referencedColumnName = "nombre"),
            @JoinColumn(name = "actividades_horario", referencedColumnName = "horario"),
            @JoinColumn(name = "actividades_fecha", referencedColumnName = "fecha")
    })
    private Actividades actividades;

    @EmbeddedId
    private ReservasKey reservasKey;

    public Reservas() {
    }

    public Reservas(Actividades actividades, ReservasKey reservasKey) {
        this.actividades = actividades;
        this.reservasKey = reservasKey;
    }

    public Actividades getActividades() {
        return actividades;
    }

    public void setActividades(Actividades actividades) {
        this.actividades = actividades;
    }

    public ReservasKey getReservasKey() {
        return reservasKey;
    }

    public void setReservasKey(ReservasKey reservasKey) {
        this.reservasKey = reservasKey;
    }

    @Override
    public String toString() {
        return "Reservas{" +
                "actividades=" + actividades +
                ", reservasKey=" + reservasKey +
                '}';
    }
}
