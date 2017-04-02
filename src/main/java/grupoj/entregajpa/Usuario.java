/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupoj.entregajpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author Miguel
 */
@Entity
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private Tipo tipo;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "borrado", nullable = false)
    private boolean borrado;
    private String nombre;
    private String apellidos;
    private String multimedia;
    private String telefono;
    private String cargo;
    private String seccion;
    
    // Relacion subir Bidireccional Usuario <-> Evento
    @OneToMany(mappedBy = "subido_by")
    private List<Evento> eventos_subidos_by;
    
    // Relacion acepta_admin Bidireccional Usuario <-> Evento
    @OneToMany(mappedBy = "aceptado_by")
    private List<Evento> eventos_aceptados_by;
    
    // Relacion me_interesa Bidireccional Evento <-> Usuarios
    @ManyToMany
    @JoinTable(name = "jnd_meInteresa", 
            joinColumns = @JoinColumn(name = "Usuario_FK"),
            inverseJoinColumns = @JoinColumn (name = "Evento_FK"))
    private List<Evento> meInteresa;
    
    // Relacion administrar_admin Unidireccional Admin -> Usuarios
    @ManyToMany
    @JoinTable(name = "jnd_administrador_usuario", 
    joinColumns = @JoinColumn(name = "administrador_FK"), 
    inverseJoinColumns = @JoinColumn (name = "usuario_FK"))
    private List<Usuario> usuarios_administrados_by; 
    
    // Relacion generar_admin Bidireccional Log <-> Usuario
    @OneToMany(mappedBy="logOwner")
    private List<Log> ownedLogs;
    
    // Relacion recibir Bidireccional Usuario <-> Notificacion
    @OneToMany(mappedBy = "usuario")
    private List<Notificacion> notificaciones_recibidas_by;
    
    // Relacion gestiona Bidireccional Usuario <-> Anuncio
    @OneToMany(mappedBy = "usuario")
    private List<Anuncio> anuncios_gestionados_by;
    
    // Relacion crea_periodista Bidireccional Usuario <-> Evento
    @OneToMany(mappedBy = "creado_by")
    private List<Evento> eventos_creados_by;
    
    // Relacion historial_eventos Unidireccional Usuario -> Evento
    @OneToMany(targetEntity = Evento.class)
    private List<Evento> historial_eventos_of;
    
    // Relacion realizar (evento) Bidireccional Usuario <-> Valoracion_eve
    @OneToMany(mappedBy = "realizado_por")
    private List<Valoracion_eve> valoraciones_eve_realizadas_by;
    
    // Relacion realizar (lugar) Bidireccional Usuario <-> Valoracion_lug
    @OneToMany(mappedBy = "realizado_por")
    private List<Valoracion_lug> valoraciones_lug_realizadas_by;
    
    
    // Autogen Code ---------------------------
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entregajpa.Usuario[ id=" + id + " ]";
    }
    
}
