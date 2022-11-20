package com.example.PersistanceApp.Pagos;

import com.example.PersistanceApp.CentrosDeportivos.CentrosDeportivos;
import com.example.PersistanceApp.Empresas.Empresas;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class PagosKey implements Serializable {
    @ManyToOne
    @JoinColumn(name = "empresas_rut")
    private Empresas empresas;


    public Empresas getEmpresas() {
        return empresas;
    }

    public void setEmpresas(Empresas empresas) {
        this.empresas = empresas;
    }

    @ManyToOne
    @JoinColumn(name = "centros_deportivos_rut")
    private CentrosDeportivos centrosDeportivos;

    public CentrosDeportivos getCentrosDeportivos() {
        return centrosDeportivos;
    }

    public void setCentrosDeportivos(CentrosDeportivos centrosDeportivos) {
        this.centrosDeportivos = centrosDeportivos;
    }

    public PagosKey(Empresas empresas, CentrosDeportivos centrosDeportivos) {
        this.empresas = empresas;
        this.centrosDeportivos = centrosDeportivos;
    }

    public PagosKey() {

    }
}
