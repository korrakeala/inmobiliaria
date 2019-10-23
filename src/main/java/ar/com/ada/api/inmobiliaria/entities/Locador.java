package ar.com.ada.api.inmobiliaria.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ar.com.ada.api.inmobiliaria.interfaces.ITieneUsuario;

/**
 * Locador
 */
@Entity
@Table(name = "locador")
public class Locador extends Persona implements ITieneUsuario {

    @Id
    @Column(name = "locador_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int locadorId;
    @JsonIgnore
    @OneToMany(mappedBy = "locador", cascade = CascadeType.ALL)
    List<Inmueble> inmuebles = new ArrayList<Inmueble>();
    
    @Transient
    private String tipoUsuario = "inmobiliaria"; // ver si tiene algo que ver



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

    public void agregarInmueble(Inmueble inmueble) {
        this.inmuebles.add(inmueble);
        inmueble.setLocador(this);
    }

    public Locador() {
    }
    
}