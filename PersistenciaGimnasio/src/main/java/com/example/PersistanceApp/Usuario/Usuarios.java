package com.example.PersistanceApp.Usuario;

import javax.persistence.*;

@Entity (name="Usuarios")
@Table
public class Usuarios {
    @Id
    @SequenceGenerator(
            name="usuarios_sequence",
            sequenceName="usuarios_sequence",
            allocationSize = 1)

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "usuarios_sequence"
    )

    @Column(name = "mail", updatable = false)
    private String mail;
    @Column(name = "contraseña", nullable = false , unique = true)
    private String contraseña;

    public Usuarios() {
    }

    public Usuarios(String mail, String contraseña) {
        this.mail = mail;
        this.contraseña = contraseña;
    }


    public String getMail() {return mail;}

    public void setMail(String mail) {this.mail = mail;}

    public String getContraseña() {return contraseña;}

    public void setContraseña(String contraseña) {this.contraseña = contraseña;}

    @Override
    public String toString() {
        return "Centro Deportivo{" +
                "mail=" + mail +
                "contraseña=" + contraseña +
                '}';
    }
}
