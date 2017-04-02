/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupoj.entregajpa;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author anaes
 */
@Entity
public class Valoracion_eve implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "calificacion", nullable=false)
    private int calificacion;
    private String comentario;
    private String fotos;
    
    // Relacion Bidireccional Usuario <-> Valoracion_eve
    @ManyToOne
    @JoinColumn(name="realizado_por_fk", nullable=false)
    private Usuario realizado_por;
    
    // Relacion Bidireccional Evento <-> Valoracion_eve
    @ManyToOne
    @JoinColumn(name="valoracion_sobre_fk", nullable=false)
    private Evento valoracion_sobre;

    
    // Autogen Code ---------------------
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Valoracion_eve)) {
            return false;
        }
        Valoracion_eve other = (Valoracion_eve) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.proyecto.Valoracion_eve[ id=" + id + " ]";
    }
    
}
