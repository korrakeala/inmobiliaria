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

    public int getAvisoId() {
        return avisoId;
    }

    public void setAvisoId(int avisoId) {
        this.avisoId = avisoId;
    }

    public int getInmuebleId() {
        return inmuebleId;
    }

    public void setInmuebleId(int inmuebleId) {
        this.inmuebleId = inmuebleId;
    }

    public int getOperacionId() {
        return operacionId;
    }

    public void setOperacionId(int operacionId) {
        this.operacionId = operacionId;
    }


    
}