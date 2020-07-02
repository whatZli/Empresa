/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_empresa;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Formacion
 */
public class Departamento {

    private String codigo;
    private String nombre;

    public static final String RRHH = "Recursos humanos";
    public static final String AtCli = "Atención al cliente";
    public static final String Vent = "Ventas";
    public static final String Comp = "Compras";
    public static final String Direc = "Dirección";

    HashMap<String, Trabajador> listaTrabajadores = new HashMap<String, Trabajador>();

    public Departamento() {
    }

    public Departamento(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        listaTrabajadores = new HashMap<String, Trabajador>();
    }

    public void addTrabajador(Trabajador trabajador) {
        if (listaTrabajadores.containsKey(trabajador.getUsuario())) {
            System.out.println("No se puede introducir el trabajador " + trabajador.getUsuario() + ". El código esta repetido.");
        } else {
            listaTrabajadores.put(trabajador.getUsuario(), trabajador);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public HashMap<String, Trabajador> getListaTrabajadores() {
        return listaTrabajadores;
    }

    public void setListaTrabajadores(HashMap<String, Trabajador> listaTrabajadores) {
        this.listaTrabajadores = listaTrabajadores;
    }

    public static void getDepartamento(String codigo) {

    }
}
