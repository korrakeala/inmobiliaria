package ar.com.ada.api.inmobiliaria.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Locatario
 */
@Entity
@Table (name = "locatario")
public class Locatario extends Persona {

    @Id
    @Column(name="locatario_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int locatarioId;

    @OneToMany (mappedBy = "locatario", cascade = CascadeType.ALL)
    List<Reserva> reservas = new ArrayList<Reserva>();
    
    Usuario usuario;

    public int getLocatarioId() {
        return locatarioId;
    }

    public void setLocatarioId(int locatarioId) {
        this.locatarioId = locatarioId;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}