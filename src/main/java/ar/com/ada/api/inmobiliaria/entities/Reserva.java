package ar.com.ada.api.inmobiliaria.entities;

import java.util.Date;

import javax.persistence.CascadeType;
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
 * Reserva
 */
@Entity
@Table(name = "reserva")
public class Reserva implements IOperable {

    @Id
    @Column(name = "reserva_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // cambio nombre del atributo para poder mapear IEsOperable con aviso

    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "locatario_id", referencedColumnName = "locatario_id")
    private Locatario locatario;

    @OneToOne(mappedBy = "inmueble", cascade = CascadeType.ALL)
    private Inmueble inmueble;

    @OneToOne(mappedBy = "operacion", cascade = CascadeType.ALL)
    private Aviso aviso;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getReservaId() {
        return id;
    }

    public void setReservaId(int reservaId) {
        this.id = reservaId;
    }

    public Locatario getLocatario() {
        return locatario;
    }

    public void setLocatario(Locatario locatario) {
        this.locatario = locatario;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Aviso getAviso() {
        return aviso;
    }

    public void setAviso(Aviso aviso) {
        this.aviso = aviso;
    }

}