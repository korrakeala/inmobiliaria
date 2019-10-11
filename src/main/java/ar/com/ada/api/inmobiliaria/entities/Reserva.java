package ar.com.ada.api.inmobiliaria.entities;

import java.util.Date;

import javax.persistence.*;

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
    private Date fecha;
    @OneToOne(mappedBy = "locatario", cascade = CascadeType.ALL)
    private Locatario locatarioId;
    @OneToOne(mappedBy = "inmueble", cascade = CascadeType.ALL)
    private Inmueble inmuebleId;





    
}