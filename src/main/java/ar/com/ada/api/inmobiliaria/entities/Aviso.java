package ar.com.ada.api.inmobiliaria.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Aviso
 */
@Entity
@Table (name = "aviso")
public class Aviso {

    @Id
    @Column(name = "aviso_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int avisoId;
    
    @ManyToOne
    @JoinColumn(name = "inmueble_id", referencedColumnName = "inmueble_id")
    private int inmuebleId;

    @Column (name ="operacion_id")
    private int operacionId;


    
}