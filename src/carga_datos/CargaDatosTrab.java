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
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author Formacion
 */
public class CargaDatosTrab {

    public Empresa cargarDatosTrab(Empresa nuevaEmpresa) {

        for (int i = 0; i < 50; i++) {
            String claveDept;
            Iterator<String> departamentos = nuevaEmpresa.getDepartamentos().keySet().iterator();
            while (departamentos.hasNext()) {
                claveDept = departamentos.next();
                Departamento d = nuevaEmpresa.getDepartamentos().get(claveDept);
                if (i % 10 == 0) {
                    //Crear jefe departamento
                    Trabajador jefe = new Trabajador(i, 1500, "t" + i, "p", d.getCodigo(), true, "Jefe" + i, "Apellido" + i, "Apellido" + i, "12345678Z", "ejemplo" + i + "@gmail.com", "Hombre", "22-06-2020", "null", true);
                    d.addTrabajador(jefe);
                    i++;
                    //Crear trabajadores
                } else {
                    for (int x = 0; x < 9; x++, i++) {
                        Trabajador trabajador = new Trabajador(i, 1500, "t" + i, "p", "AtCli", false, "Nombre" + i, "Apellido" + i, "Apellido" + i, "12345678Z", "ejemplo" + i + "@gmail.com", "Hombre", "22-06-2020", "null", true);
                        d.addTrabajador(trabajador);
                    }
                }
            }
        }
        return nuevaEmpresa;
    }
}
