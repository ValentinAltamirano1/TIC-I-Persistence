package com.example.PersistanceApp.Actividades;


import com.example.PersistanceApp.CentrosDeportivos.CentrosDeportivos;

import javax.persistence.*;


@Entity(name = "Actividades")
@Table()
public class Actividades {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_actividad", nullable = false)
    private int id_actividad;


   /* @ManyToMany(mappedBy = "actividades")
    private List<Empleados> empleados=new ArrayList<>() ;

    /*@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "actividades_empleados_mapping")
    @JoinColumn(name = "id_actividad")
    @JoinColumn(name = "id_empleado")
    private Set<Empleados> empleados;*/



    /*@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "rut")
    private CentrosDeportivos centrosDeportivos; // muchos actividades pueden pertenecer a un mismo centro deportivo

   /* @OneToMany
    @JoinColumn(name = "id_actividad")
    private Set<Imagenes> imagenes;*/
    @ManyToOne
    @JoinColumn(name = "centros_deportivos_rut")
    private CentrosDeportivos   centrosDeportivos;

    @Column(name = "nombre", updatable = false)
    private String nombre;
    @Column(name = "horario",nullable = false )
    private String horario;
    @Column(name = "precio" ,nullable = false)
    private int precio;
    @Column(name = "categoria" ,nullable = false )
    private String categoria;
    @Column(name = "capacidad" , nullable = false)
    private int capacidad;

    @Column(name = "descripcion" , nullable = false)
    private String descripcion;

    @Column(name = "cupos" , nullable = false)
    private int cupos;

    @Column(name = "imagen", nullable = false)
    @Lob
    private String imagen;

    public CentrosDeportivos getCentrosDeportivos() {
        return centrosDeportivos;
    }

    public void setCentrosDeportivos(CentrosDeportivos centrosDeportivos) {
        this.centrosDeportivos = centrosDeportivos;
    }

    public Actividades() {
    }

    public Actividades(String nombre, String horario, int precio, String categoria, int capacidad, String descripcion, int cupos, String imagen) {
        this.nombre = nombre;
        this.horario = horario;
        this.precio = precio;
        this.categoria = categoria;
        this.capacidad = capacidad;
        this.descripcion = descripcion;
        this.cupos = cupos;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHorario() {return horario;
    }

    public void setHorario(String horario) {this.horario = horario;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getId_actividad() {
        return id_actividad;
    }

    public void setId_actividad(int id_actividad) {
        this.id_actividad = id_actividad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCupos() {
        return cupos;
    }

    public void setCupos(int cupos) {
        this.cupos = cupos;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Actividades{" +
                "nombre='" + nombre + '\'' +
                ", horario='" + horario + '\'' +
                ", precio=" + precio +
                ", categoria='" + categoria + '\'' +
                ", capacidad=" + capacidad +
                ", descripcion='" + descripcion + '\'' +
                ", cupos=" + cupos +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}
