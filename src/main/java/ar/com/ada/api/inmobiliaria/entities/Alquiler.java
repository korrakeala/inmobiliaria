package ar.com.ada.api.inmobiliaria.entities;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import ar.com.ada.api.inmobiliaria.interfaces.IOperable;

/**
 * Alquiler
 */
@Entity
@Table(name = "alquiler")
public class Alquiler implements IOperable {

    @Id
    @Column(name = "alquiler_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // cambio nombre del atributo para poder mapear IEsOperable con aviso

    @Column(name = "tipo_alquiler")
    private String tipoAlquiler;
    private String moneda;
    private double valor;

    @Column(name = "plazo_meses")
    private String plazoMeses;

    @OneToOne(mappedBy = "operacion", cascade = CascadeType.ALL)
    private Aviso aviso;

    public int getAlquilerId() {
        return id;
    }

    public void setAlquilerId(int alquilerId) {
        this.id = alquilerId;
    }

    public String getTipoAlquiler() {
        return tipoAlquiler;
    }

    public void setTipoAlquiler(String tipoAlquiler) {
        this.tipoAlquiler = tipoAlquiler;
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

    public String getPlazoMeses() {
        return plazoMeses;
    }

    public void setPlazoMeses(String plazoMeses) {
        this.plazoMeses = plazoMeses;
    }

    public Aviso getAviso() {
        return aviso;
    }

    public void setAviso(Aviso aviso) {
        this.aviso = aviso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}