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
public class Empresa {

    private String nombre;
    private String direccion;
    private String NIF;

    HashMap<String, Departamento> departamentos = new HashMap<>();
    HashMap<String, Cliente> clientes = new HashMap<>();

    public Empresa(String nombre, String direccion, String NIF) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.NIF = NIF;

        departamentos = new HashMap<>();
        clientes = new HashMap<>();

    }

    public void addDepartamento(Departamento d) {
        if (departamentos.containsKey(d.getCodigo())) {
            System.out.println("No se puede introducir el departamento. El código esta repetido.");
        } else {
            this.departamentos.put(d.getCodigo(), d);
        }
    }

    public void addCliente(Cliente c) {
        if (clientes.containsKey(c.getCod_cliente())) {
            System.out.println("No se puede introducir el cliente. El código esta repetido.");
        } else {
            clientes.put(c.getCod_cliente(), c);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public HashMap<String, Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(HashMap<String, Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    public HashMap<String, Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(HashMap<String, Cliente> clientes) {
        this.clientes = clientes;
    }

}
