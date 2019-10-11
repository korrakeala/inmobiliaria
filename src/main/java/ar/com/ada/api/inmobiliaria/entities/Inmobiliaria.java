package ar.com.ada.api.inmobiliaria.entities;

import javax.persistence.*;

/**
 * Inmobiliaria
 */
@Entity
@Table (name = "inmobiliaria")
public class Inmobiliaria {

    @Id
    @Column (name ="inmobiliaria_id")
    private int inmobiliariaId;

    private String nombre;

    private String cuil;

    @Column (name = "usuario_id")
    private int usuarioId;

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

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    
}