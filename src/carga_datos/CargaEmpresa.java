/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carga_datos;

import app_empresa.Empresa;

/**
 *
 * @author Formacion
 */
public class CargaEmpresa {

    public static Empresa CargaEmpresa() {
        CargaDatosDepart cgd = new CargaDatosDepart();
        //Crear empresa y carga de datos
        Empresa nuevaEmpresa = new Empresa("Empresa 1", "Calle Magallanes", "123654987D");
        nuevaEmpresa = cgd.cargarTodosLosDatos(nuevaEmpresa);

        return nuevaEmpresa;
    }
}
