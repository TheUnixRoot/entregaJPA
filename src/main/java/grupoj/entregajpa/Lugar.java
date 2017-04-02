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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author anaes
 */
@Entity
public class Lugar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String geolocalizacion;
    @Column(nullable = false)
    private boolean borrado;
    private String fotos;
    private String descripcion;
    
    // Relacion ocurre Bidireccional Evento <-> Lugar
    @OneToMany(mappedBy = "ocurre_in")
    private List<Evento> eventos_ocurren_in;

    // Relacion recibe Bidireccional Valoracion_lug <-> Lugar
    @OneToMany(mappedBy = "valoracion_sobre")
    private List<Valoracion_lug> valoraciones_sobre;
    
    // Autogen Code ------------
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lugar)) {
            return false;
        }
        Lugar other = (Lugar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.proyecto.Luegar[ id=" + id + " ]";
    }
    
}
