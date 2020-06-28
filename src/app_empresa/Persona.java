/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_empresa;

/**
 *
 * @author Formacion
 */
public class Persona {
    
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String dni;
    private String email;
    private String sexo;
    private String f_alta;
    private String f_baja;
    private boolean activo;

    public Persona(String nombre, String apellido1, String apellido2, String dni, String email, String sexo, String f_alta, String f_baja, boolean activo) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.dni = dni;
        this.email = email;
        this.sexo = sexo;
        this.f_alta = f_alta;
        this.f_baja = f_baja;
        this.activo = activo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getF_alta() {
        return f_alta;
    }

    public void setF_alta(String f_alta) {
        this.f_alta = f_alta;
    }

    public String getF_baja() {
        return f_baja;
    }

    public void setF_baja(String f_baja) {
        this.f_baja = f_baja;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    
    
}
