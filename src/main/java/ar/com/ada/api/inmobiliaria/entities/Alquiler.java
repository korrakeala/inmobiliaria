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

    public int getAlquilerId() {
        return alquilerId;
    }

    public void setAlquilerId(int alquilerId) {
        this.alquilerId = alquilerId;
    }

    public int getOperacionId() {
        return operacionId;
    }

    public void setOperacionId(int operacionId) {
        this.operacionId = operacionId;
    }

    public String getTipoAlquiler() {
        return tipoAlquiler;
    }

    public void setTipoAlquiler(String tipoAlquiler) {
        this.tipoAlquiler = tipoAlquiler;
    }

    public String getPlazoAlquiler() {
        return plazoAlquiler;
    }

    public void setPlazoAlquiler(String plazoAlquiler) {
        this.plazoAlquiler = plazoAlquiler;
    }

    
}