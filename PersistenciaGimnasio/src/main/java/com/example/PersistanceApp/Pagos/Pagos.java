package com.example.PersistanceApp.Pagos;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "Pagos")
@Table()
public class Pagos {

    @Column(name = "gasto")
    private long gasto;

    @EmbeddedId
    PagosKey pagosKey;


    public long getGasto() {
        return gasto;
    }

    public void setGasto(long gasto) {
        this.gasto = gasto;
    }

    public PagosKey getPagosKey() {
        return pagosKey;
    }

    public void setPagosKey(PagosKey pagosKey) {
        this.pagosKey = pagosKey;
    }

    public Pagos(long gasto, PagosKey pagosKey) {
        this.gasto = gasto;
        this.pagosKey = pagosKey;
    }
    public Pagos() {

    }

}
