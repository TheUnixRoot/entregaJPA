/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupoj.entregajpa;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author juanp
 */
@Entity
public class Log implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cambiosRealizados;
    @ManyToOne
    @JoinColumn(name="admin_id_fk", nullable=false)
    private Usuario logOwner;

    public String getCambiosRealizados() {
        return cambiosRealizados;
    }

    public void setCambiosRealizados(String cambiosRealizados) {
        this.cambiosRealizados = cambiosRealizados;
    }

    public Usuario getLogOwner() {
        return logOwner;
    }

    public void setLogOwner(Usuario logOwner) {
        this.logOwner = logOwner;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Log)) {
            return false;
        }
        Log other = (Log) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupoj.entregajpa.Log[ id=" + id + " ]";
    }
    
}
