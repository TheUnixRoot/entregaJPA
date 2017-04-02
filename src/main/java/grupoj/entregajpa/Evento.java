/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupoj.entregajpa;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author juanp
 */
@Entity
public class Evento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(nullable = false)
    private String tipo;
    @Column(nullable = false)
    private boolean borrado;
    private String descripcion;
    private double precio;
    private boolean verificado;
    
    // TO-DO ||||
    // Relacion consultar Bidireccional Evento <-> Usuario_no
    @ManyToMany
    private List<Usuario_no> consultado_by;
    // TO-DO ^^^^
    
    // Relacion Bidireccional Tag <-> Evento
    @ManyToMany
    @JoinTable(name = "jnd_tag_evento",
            joinColumns = @JoinColumn(name = "tags_FK"),
            inverseJoinColumns = @JoinColumn(name = "evento_FK"))
    private List<Tags> tagged_by;
    
    // Relacion crea_periodista Bidireccional Usuario <-> Evento
    @ManyToOne
    @JoinColumn(name="creado_por_FK", nullable=false)
    private Usuario creado_by;
    
    // Relacion ocurre Bidireccional Evento <-> Lugar
    @ManyToOne
    @JoinColumn(name="ocurre_en_FK", nullable=false)
    private Lugar ocurre_in;
    
    // Relacion recibe Bidireccional Valoracion_eve <-> Evento
    @OneToMany(mappedBy = "valoracion_sobre")
    private List<Valoracion_eve> valoraciones_sobre;
    
    // Relacion subir Bidireccional Usuario <-> Evento
    @ManyToOne
    @JoinColumn(name = "subido_by_FK", nullable = false)
    private Usuario subido_by;
    
    // Relacion acepta_admin Bidireccional Usuario <-> Evento
    @ManyToOne
    @JoinColumn(name = "aceptado_by_FK", nullable = false)
    private Usuario aceptado_by;
    
    // Autogen Code ----------
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evento)) {
            return false;
        }
        Evento other = (Evento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupoj.entregajpa.Evento[ id=" + id + " ]";
    }
    
}
