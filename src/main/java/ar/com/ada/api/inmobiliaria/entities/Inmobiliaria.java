package ar.com.ada.api.inmobiliaria.entities;

import javax.persistence.*;

import ar.com.ada.api.inmobiliaria.interfaces.ITieneUsuario;

/**
 * Inmobiliaria
 */
@Entity
@Table(name = "inmobiliaria")
public class Inmobiliaria implements ITieneUsuario {

    @Id
    @Column(name = "inmobiliaria_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // cambio nombre del atributo para poder mapear ITieneUsuario con Usuario

    private String nombre;

    private String cuit;

    @OneToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    private Usuario usuario;

    @Transient
    private String tipoUsuario = "Inmobiliaria";

    public int getInmobiliariaId() {
        return id;
    }

    public void setInmobiliariaId(int inmobiliariaId) {
        this.id = inmobiliariaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    @Override
    public String toString() {
        return tipoUsuario;
    }

    @Override
    public int getId() {
        
        return this.getId();
    }
}