package ar.com.ada.api.inmobiliaria.entities;

import javax.persistence.*;

/**
 * Aviso
 */
@Entity
@Table (name ="aviso")
public class Aviso {

    @Id
    @Column(name="aviso_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int avisoId;
    
    @Column(name="inmueble_id")
    private int inmuebleId;

    @Column (name="operacion_id")
    private int operacionId;


    
}