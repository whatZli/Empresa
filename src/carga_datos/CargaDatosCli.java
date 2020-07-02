/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carga_datos;

import app_empresa.Cliente;
import app_empresa.Empresa;

/**
 *
 * @author Formacion
 */
public class CargaDatosCli {

    public Empresa CargaDatosCli(Empresa nuevaEmpresa) {
        //Crear clientes
        for (int i = 0; i < 100; i++) {
            Cliente cliente = new Cliente("c" + i, "p", 0, 0, "Cliente" + i, "Apellido1", "Apellido2", "71041502E", "cliente" + i + "@gmail.com", "Mujer", "22-06-2020", null, true);
            nuevaEmpresa.addCliente(cliente);

        }
        return nuevaEmpresa;
    }
}
