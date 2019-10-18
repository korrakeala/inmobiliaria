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
public class Reserva implements IOperable{

    @Id
    @Column(name = "reserva_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservaId;

    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "locatario_id", referencedColumnName = "locatario_id")
    private Locatario locatario;
    
    @OneToOne(mappedBy = "inmueble", cascade = CascadeType.ALL)
    private Inmueble inmuebleId;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Inmueble getInmuebleId() {
        return inmuebleId;
    }

    public void setInmuebleId(Inmueble inmuebleId) {
        this.inmuebleId = inmuebleId;
    }





    
}