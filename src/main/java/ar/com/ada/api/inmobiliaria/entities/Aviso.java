package ar.com.ada.api.inmobiliaria.entities;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import ar.com.ada.api.inmobiliaria.interfaces.IOperable;

/**
 * Aviso
 */
@Entity
@Table(name = "aviso")
public class Aviso {

    @Id
    @Column(name = "aviso_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int avisoId;

    @ManyToOne
    @JoinColumn(name = "inmueble_id", referencedColumnName = "inmueble_id")
    private int inmuebleId;

    // @Column(name = "operacion_id")
    // private int operacionId;

    @OneToOne(mappedBy = "id", cascade = CascadeType.ALL)
    private IOperable operacion;

    private String tipoOperacion;

    public int getAvisoId() {
        return avisoId;
    }

    public void setAvisoId(int avisoId) {
        this.avisoId = avisoId;
    }

    public int getInmuebleId() {
        return inmuebleId;
    }

    public void setInmuebleId(int inmuebleId) {
        this.inmuebleId = inmuebleId;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

}