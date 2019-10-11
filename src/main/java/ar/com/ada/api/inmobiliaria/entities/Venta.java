package ar.com.ada.api.inmobiliaria.entities;

import javax.persistence.*;

import ar.com.ada.api.inmobiliaria.interfaces.IOperable;

/**
 * Venta
 */
@Entity
@Table(name = "venta")
public class Venta implements IOperable{
    
    @Id
    @Column(name = "venta_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int ventaId;
    String moneda;
    double valor;
    @Column(name="aviso_id")
    int avisoId;
    
}