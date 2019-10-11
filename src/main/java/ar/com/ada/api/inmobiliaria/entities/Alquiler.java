package ar.com.ada.api.inmobiliaria.entities;

import javax.persistence.*;

import ar.com.ada.api.inmobiliaria.interfaces.IOperable;

/**
 * Alquiler
 */
@Entity
@Table(name = "alquiler")
public class Alquiler implements IOperable{

    @Id
    @Column(name = "alquiler_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int alquilerId;

    @Column(name = "operacion_id")
    private int operacionId;

    @Column(name="tipo_alquiler")
    private String tipoAlquiler;

    @Column(name="plazo_alquiler")
    private String plazoAlquiler;

    
}