package ar.com.ada.api.inmobiliaria.entities;

import javax.persistence.*;

/**
 * Inmueble
 */
@Entity
@Table (name = "inmueble")
public class Inmueble {

    @Id
    @Column (name ="inmueble_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int inmuebleId;
    @Column (name = "locador_id")
    int locadorId;
    Locador locador;
    @Column (name = "tipo_inmueble")
    String tipoInmueble;
    String direccion;
    boolean reservado;
    // Coordenada ubicacion; (para usar API Maps a futuro)
    int superficie; //en m2
    @Column (name = "cant_dormitorio")
    int cantDormitorio;
    @Column (name = "apto_prof")
    boolean aptoProf;
    String disposicion;
    @Column (name = "cant_banios")
    int cantBanios;
    String instalaciones; //qué onda esto en DB?
    @Column (name = "antiguedad_anios")
    int antiguedadAnios;
    // (etc)
    Aviso aviso;
    @Column (name = "aviso_id")
    int avisoId;

    public int getInmuebleId() {
        return inmuebleId;
    }

    public void setInmuebleId(int inmuebleId) {
        this.inmuebleId = inmuebleId;
    }

    public int getLocadorId() {
        return locadorId;
    }

    public void setLocadorId(int locadorId) {
        this.locadorId = locadorId;
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

    public String getInstalaciones() {
        return instalaciones;
    }

    public void setInstalaciones(String instalaciones) {
        this.instalaciones = instalaciones;
    }

    public int getAntiguedadAnios() {
        return antiguedadAnios;
    }

    public void setAntiguedadAnios(int antiguedadAnios) {
        this.antiguedadAnios = antiguedadAnios;
    }

    public Aviso getAviso() {
        return aviso;
    }

    public void setAviso(Aviso aviso) {
        this.aviso = aviso;
    }

    public int getAvisoId() {
        return avisoId;
    }

    public void setAvisoId(int avisoId) {
        this.avisoId = avisoId;
    }
}