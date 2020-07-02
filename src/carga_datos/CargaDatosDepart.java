/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carga_datos;

import app_empresa.Cliente;
import app_empresa.Departamento;
import app_empresa.Empresa;
import app_empresa.Trabajador;
import java.util.Iterator;

/**
 *
 * @author Formacion
 */
public class CargaDatosDepart {

    public Empresa cargarTodosLosDatos(Empresa nuevaEmpresa) {

        //Crear departamentos
        Departamento deptDireccion = new Departamento("Direc", "Dirección");
        Departamento deptAtencionCliente = new Departamento("AtCli", "Atención al cliente");
        Departamento deptVentas = new Departamento("Vent", "Ventas");
        Departamento deptCompras = new Departamento("Comp", "Compras");
        Departamento deptRrhh = new Departamento("RRHH", "Recursos Humanos");

        //Asignar departamentos a la colección
        nuevaEmpresa.addDepartamento(deptDireccion);
        nuevaEmpresa.addDepartamento(deptAtencionCliente);
        nuevaEmpresa.addDepartamento(deptVentas);
        nuevaEmpresa.addDepartamento(deptCompras);
        nuevaEmpresa.addDepartamento(deptRrhh);

        CargaDatosTrab cdt = new CargaDatosTrab();
        nuevaEmpresa = cdt.cargarDatosTrab(nuevaEmpresa);

        CargaDatosCli cdc = new CargaDatosCli();
        nuevaEmpresa = cdc.CargaDatosCli(nuevaEmpresa);

        return nuevaEmpresa;

    }
}
