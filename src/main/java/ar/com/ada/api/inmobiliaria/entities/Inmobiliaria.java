package ar.com.ada.api.inmobiliaria.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ar.com.ada.api.inmobiliaria.interfaces.ITieneUsuario;

/**
 * Inmobiliaria
 */
@Entity
@Table(name = "inmobiliaria")
public class Inmobiliaria implements ITieneUsuario {

    @Id
    @Column(name = "inmobiliaria_id")
    private int inmobiliariaId;

    private String nombre;

    private String cuil;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    private Usuario usuario;

    public int getInmobiliariaId() {
        return inmobiliariaId;
    }

    public void setInmobiliariaId(int inmobiliariaId) {
        this.inmobiliariaId = inmobiliariaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        this.usuario.getTienenUsuario().add(this);  // funcionará?
    }

}