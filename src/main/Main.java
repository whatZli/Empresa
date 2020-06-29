/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import app_empresa.Cliente;
import app_empresa.Empresa;
import app_empresa.Mensaje;
import app_empresa.Login;
import app_empresa.Trabajador;
import carga_datos.CargaDatosDepart;
import db.Conexion;
import carga_datos.CargaEmpresa;
import hilos.AvisadorMovimientoBD;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Scanner;
import menu.Menu;
import menu.MenuCliente;
import menu.MenuLogin;
import menu.MenuTrabajadorComun;
import operaciones_cliente.OperacionesCliente;
import operaciones_trabajador.OperacionesTrabajadorComun;

/**
 *
 * @author Formacion
 */
public class Main {

    public static void main(String[] args) {

        //Declaración de variables
        MenuLogin ml = new MenuLogin();
        Login l = new Login();
        Trabajador userTraLogueado = null;
        Cliente userCliLogueado = null;

        //Crear empresa y carga de datos
        Empresa nuevaEmpresa = CargaEmpresa.CargaEmpresa();

        //Lanzar formulario login
        do {
            String usuarioContraseña = ml.formularioLogIn();

            String[] aUsuarioContraseña = usuarioContraseña.split("-");
            String usuarioIntroducido = aUsuarioContraseña[0];
            String passwordIntroducido = aUsuarioContraseña[1];

            userTraLogueado = l.validarUsuarioContraseñaTrabajador(usuarioIntroducido, passwordIntroducido, nuevaEmpresa);

            if (userTraLogueado == null) {//Si no hay un trabajador se va a buscar un cliente
                userCliLogueado = l.validarUsuarioContraseñaCliente(usuarioIntroducido, passwordIntroducido, nuevaEmpresa);

                if (userCliLogueado != null) {//Si se obtiene un cliente

                    SwitchClientes.switchClientes(userCliLogueado);

                } else {//Si no se ha encontrado un Trabajador ni un Cliente
                    System.out.println("No se ha encontrado el usuario");
                }
            }

            if (userTraLogueado != null) {

                SwitchTrabajadores.switchTrabajadores(userTraLogueado, nuevaEmpresa);

            }

        } while (userTraLogueado == null || userCliLogueado == null);

    }

}
