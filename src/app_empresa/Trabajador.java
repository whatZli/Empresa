/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_empresa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Formacion
 */
public class Trabajador extends Persona {

    private int cod_trabajador;
    private float salario;
    private String usuario;
    private String password;
    private String tipo;
    private boolean es_jefe;

    static int num_trabajadores = 0;

    private LinkedList<Mensaje> mensajes = new LinkedList<Mensaje>();

    public Trabajador(int cod_trabajador, float salario, String usuario, String password, String tipo, boolean es_jefe, String nombre, String apellido1, String apellido2, String dni, String email, String sexo, String f_alta, String f_baja, boolean activo) {
        super(nombre, apellido1, apellido2, dni, email, sexo, f_alta, f_baja, activo);
        this.cod_trabajador = cod_trabajador;
        this.salario = salario;
        this.usuario = usuario;
        this.password = password;
        this.tipo = tipo;
        this.es_jefe = es_jefe;
        this.num_trabajadores++;
        mensajes = new LinkedList<Mensaje>();
    }

    public void addMensaje(Mensaje m) {
        this.mensajes.add(m);
    }

    public int getCod_trabajador() {
        return cod_trabajador;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LinkedList<Mensaje> getMensajes() {
        return mensajes;
    }

    public void setMensajes(LinkedList<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }

    public void setCod_trabajador(int cod_trabajador) {
        this.cod_trabajador = cod_trabajador;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEs_jefe() {
        return es_jefe;
    }

    public void setEs_jefe(boolean es_jefe) {
        this.es_jefe = es_jefe;
    }

    public static int getNum_trabajadores() {
        return num_trabajadores;
    }

    public static void setNum_trabajadores(int num_trabajadores) {
        Trabajador.num_trabajadores = num_trabajadores;
    }

}
