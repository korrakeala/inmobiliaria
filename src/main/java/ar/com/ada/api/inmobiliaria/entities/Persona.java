package ar.com.ada.api.inmobiliaria.entities;

import javax.persistence.MappedSuperclass;

/**
 * Persona
 */
@MappedSuperclass
public class Persona {

    private String nombre;
    private String dni;
    private int edad;
    private String email;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

}