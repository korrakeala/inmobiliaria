package ar.com.ada.api.inmobiliaria.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import ar.com.ada.api.inmobiliaria.interfaces.IOperable;

/**
 * Venta
 */
@Entity
@Table(name = "venta")
public class Venta implements IOperable {

    @Id
    @Column(name = "venta_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id; // cambio nombre del atributo para poder mapear IEsOperable con aviso

    String moneda;
    double valor;

    @OneToOne
    @JoinColumn(name= "aviso_id", referencedColumnName = "aviso_id")
    private Aviso aviso;

    public int getVentaId() {
        return id;
    }

    public void setVentaId(int ventaId) {
        this.id = ventaId;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
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