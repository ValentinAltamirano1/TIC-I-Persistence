package com.example.PersistanceApp.Usuario;

import javax.persistence.*;

@Entity (name="Usuarios")
@Table
public class Usuarios {
    @Id
    @Column(name = "mail", updatable = false)
    private String mail;
    @Column(name = "contraseña", nullable = false , unique = true)
    private String contraseña;

    @Column(name = "tipoUsuario", nullable = false )
    private String tipoUsuario;
    public Usuarios() {
    }

    public Usuarios(String mail, String contraseña, String tipoUsuario) {
        this.mail = mail;
        this.contraseña = contraseña;
        this.tipoUsuario = tipoUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getMail() {return mail;}

    public void setMail(String mail) {this.mail = mail;}

    public String getContraseña() {return contraseña;}

    public void setContraseña(String contraseña) {this.contraseña = contraseña;}

    @Override
    public String toString() {
        return "Usuarios{" +
                "mail='" + mail + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", tipoUsuario='" + tipoUsuario + '\'' +
                '}';
    }
}

