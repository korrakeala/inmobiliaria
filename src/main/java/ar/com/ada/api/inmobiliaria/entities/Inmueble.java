package ar.com.ada.api.inmobiliaria.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Inmueble
 */
@Entity
@Table(name = "inmueble")
public class Inmueble {

    @Id
    @Column(name = "inmueble_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int inmuebleId;

    @ManyToOne
    @JoinColumn(name = "locador_id", referencedColumnName = "locador_id")
    Locador locador;

    @OneToMany(mappedBy = "inmueble", cascade = CascadeType.ALL)
    List<Aviso> avisos = new ArrayList<Aviso>();

    @OneToOne
    @JoinColumn(name = "reserva_id", referencedColumnName = "reserva_id")
    private Reserva reserva;

    @Column(name = "tipo_inmueble")
    String tipoInmueble;
    @Column(name = "cant_amb")
    int cantAmb;
    String direccion;
    boolean reservado;
    // Coordenada ubicacion; (para usar API Maps a futuro)
    int superficie; // en m2
    @Column(name = "cant_dormitorio")
    int cantDormitorio;
    @Column(name = "apto_prof")
    boolean aptoProf;
    String disposicion;
    @Column(name = "cant_banios")
    int cantBanios;
    @Column(name = "antiguedad_anios")
    int antiguedadAnios;
    // (etc)

    public int getInmuebleId() {
        return inmuebleId;
    }

    public void setInmuebleId(int inmuebleId) {
        this.inmuebleId = inmuebleId;
    }

    public Locador getLocador() {
        return locador;
    }

    public void setLocador(Locador locador) {
        this.locador = locador;
    }

    public String getTipoInmueble() {
        return tipoInmueble;
    }

    public void setTipoInmueble(String tipoInmueble) {
        this.tipoInmueble = tipoInmueble;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isReservado() {
        return reservado;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public int getCantDormitorio() {
        return cantDormitorio;
    }

    public void setCantDormitorio(int cantDormitorio) {
        this.cantDormitorio = cantDormitorio;
    }

    public boolean isAptoProf() {
        return aptoProf;
    }

    public void setAptoProf(boolean aptoProf) {
        this.aptoProf = aptoProf;
    }

    public String getDisposicion() {
        return disposicion;
    }

    public void setDisposicion(String disposicion) {
        this.disposicion = disposicion;
    }

    public int getCantBanios() {
        return cantBanios;
    }

    public void setCantBanios(int cantBanios) {
        this.cantBanios = cantBanios;
    }

    public int getAntiguedadAnios() {
        return antiguedadAnios;
    }

    public void setAntiguedadAnios(int antiguedadAnios) {
        this.antiguedadAnios = antiguedadAnios;
    }

    public List<Aviso> getAvisos() {
        return avisos;
    }

    public void setAvisos(List<Aviso> avisos) {
        this.avisos = avisos;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public int getCantAmb() {
        return cantAmb;
    }

    public void setCantAmb(int cantAmb) {
        this.cantAmb = cantAmb;
    }
}