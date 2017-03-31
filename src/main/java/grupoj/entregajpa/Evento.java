package grupoj.entregajpa;


import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author David
 */
public class Evento implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column( name = "nombre", nullable = false)
    private String nombre;
    @Column( name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column( name = "precio", nullable = false)
    private double precio;
    @Column( name = "tipo", nullable = false)
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    private boolean verificado;
    @Column( name = "descripcion", nullable = false)
    private String descripcion;
    @Column( name = "geolocalizacion", nullable = false)
    private String geolocalizacion;
    private boolean borrado;
    
    // Relaciones con tabla Usuario
    @ManyToMany(mappedBy = "meInteresa")
    private List<Usuario> meGustaUsuarios;
    
    private Usuario me_gusta;
    private Usuario sudido;
    private Usuario crea_periodista;
    private Usuario historialEventos;
    private Usuario aceptar_Admin; 
    
    // Relación con tabla Lugar
    @ManyToOne
    private Lugar ocurre;
    
    // Relación con tabla Usuario_No
    @ManyToMany
    @JoinTable(name = "rel_UsuarioNo_eventos",
            joinColumns = @JoinColumn(name = "usuarioNo_fk"),
            inverseJoinColumns = @JoinColumn(name = "evento_fk"))
    private List<Evento> usuarioNoEnEventos;
            
    // Relación con tabla Tags
    @ManyToMany
    @JoinTable(name = "rel_tags_eventos",
            joinColumns = @JoinColumn(name = "tags_fk"),
            inverseJoinColumns = @JoinColumn(name = "evento_fk"))
    private List<Evento> tagEnEventos;
    
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public boolean isVerificado() {
        return verificado;
    }

    public void setVerificado(boolean verificado) {
        this.verificado = verificado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getGeolocalizacion() {
        return geolocalizacion;
    }

    public void setGeolocalizacion(String geolocalizacion) {
        this.geolocalizacion = geolocalizacion;
    }

    public boolean isBorrado() {
        return borrado;
    }

    public void setBorrado(boolean borrado) {
        this.borrado = borrado;
    }
    
    
}
