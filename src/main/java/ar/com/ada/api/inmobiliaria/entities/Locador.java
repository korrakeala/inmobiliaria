package ar.com.ada.api.inmobiliaria.entities;

import java.util.*;

import javax.persistence.*;

/**
 * Locador
 */
@Entity
@Table (name = "locador")
public class Locador extends Persona {

    @Id
    @Column(name="locador_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int locadorId;
    List<Inmueble> inmuebles = new ArrayList<Inmueble>();

    public int getLocadorId() {
        return locadorId;
    }

    public void setLocadorId(int locadorId) {
        this.locadorId = locadorId;
    }

    public List<Inmueble> getInmuebles() {
        return inmuebles;
    }

    public void setInmuebles(List<Inmueble> inmuebles) {
        this.inmuebles = inmuebles;
    }
}