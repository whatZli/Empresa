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
import Db.Conexion;
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
import operaciones_cliente.OperacionesCliente;
import operaciones_trabajador.OperacionesTrabajadorComun;

/**
 *
 * @author Formacion
 */
public class Main {

    public static void main(String[] args) {

        //Declaración de variables
        Scanner scan = new Scanner(System.in);
        Menu menu = new Menu();
        Login l = new Login();
        CargaDatosDepart cgd = new CargaDatosDepart();
        OperacionesTrabajadorComun otc = new OperacionesTrabajadorComun();
        Trabajador userTraLogueado = null;
        Cliente userCliLogueado = null;
        LinkedList<Mensaje> listaMensajes = null;
        Connection con;
        Boolean salir = false;
        OperacionesCliente oc = new OperacionesCliente();

        //Crear empresa y carga de datos
        Empresa nuevaEmpresa = CargaEmpresa.CargaEmpresa();

        //Lanzar formulario login
        do {
            String usuarioContraseña = menu.formularioLogIn();

            String[] aUsuarioContraseña = usuarioContraseña.split("-");
            String usuarioIntroducido = aUsuarioContraseña[0];
            String passwordIntroducido = aUsuarioContraseña[1];

            userTraLogueado = l.validarUsuarioContraseñaTrabajador(usuarioIntroducido, passwordIntroducido, nuevaEmpresa);
            if (userTraLogueado == null) {//Si no hay un trabajador se va a buscar un cliente
                userCliLogueado = l.validarUsuarioContraseñaCliente(usuarioIntroducido, passwordIntroducido, nuevaEmpresa);
                if (userCliLogueado != null) {//Si se obtiene un cliente
                    int opcionElegida = -1;
                    menu.bienvenida(userCliLogueado);
                    do {
                        menu.menuCliente();

                        opcionElegida = menu.pedirOpcion();

                        switch (opcionElegida) {
                            case 0:
                                break;
                            case 1:
                                oc.listarArticulos();
                                break;
                            case 2:
                                oc.verArticulo(opcionElegida);
                                break;
                            case 3:
                                oc.comprarArticlo(userCliLogueado);
                                break;
                            case 4:
                                oc.verTusCompras(userCliLogueado);
                                break;
                            case 5:
                                AvisadorMovimientoBD avbd = new AvisadorMovimientoBD();
                                avbd.run();
                                break;
                        }
                    } while (opcionElegida != 0);

                } else {//Si no se ha encontrado un Trabajador ni un Cliente
                    System.out.println("No se ha encontrado el usuario");
                }
            }

            if (userTraLogueado != null) {

                int numOpciones = 0, opcionElegidaPrincipal = -1, opcionElegida = -1;
                menu.bienvenida(userTraLogueado);

                switch (userTraLogueado.getTipo()) {
                    case "Direc":
                        do {
                            menu.menuTrabajadorComun();
                            menu.menuTrabajadorDireccion();
                            numOpciones = 17;
                            if (userTraLogueado.isEs_jefe()) {
                                menu.funcionesJefeDepartamento();
                                numOpciones += 2;
                            }

                            System.out.println("Introduce una opción");
                            opcionElegida = scan.nextInt();

                            if (opcionElegida < 0 || opcionElegida >= numOpciones) {
                                System.out.println("Error -> Introduzca una opción válida");
                            } else {
                                switch (opcionElegida) {
                                    case 0:
                                        salir = true;
                                        break;
                                }
                            }
                        } while (opcionElegida > 0 && opcionElegida <= numOpciones || !salir);

                        break;

                    case "AtCli":
                        do {
                            menu.menuTrabajadorComun();
                            menu.menuTrabajadorAC();
                            numOpciones = 13;
                            if (userTraLogueado.isEs_jefe()) {
                                menu.funcionesJefeDepartamento();
                                numOpciones += 2;
                            }

                            System.out.println("Introduce una opción");
                            opcionElegida = scan.nextInt();

                            if (opcionElegida < 0 || opcionElegida >= numOpciones) {
                                System.out.println("Error -> Introduzca una opción válida");
                            } else {
                                switch (opcionElegida) {
                                    case 0:
                                        salir = true;
                                        break;
                                    case 1:
                                        String trabajadorDestino = menu.enviarCorreoACompañero();
                                        otc.enviarCorreo(nuevaEmpresa, trabajadorDestino, userTraLogueado);

                                        break;
                                    case 2:
                                        int menuComprobarNC = -1;
                                        do {
                                            menuComprobarNC = otc.checkCorreoNoContestado(userTraLogueado, nuevaEmpresa);
                                        } while (menuComprobarNC != 0);
                                        break;

                                    case 3:
                                        int menuComprobarNL = -1;
                                        do {
                                            menuComprobarNL = otc.checkCorreoNoLeido(userTraLogueado);
                                        } while (menuComprobarNL != 0);
                                        break;
                                    case 4:
                                        break;
                                    case 5:
                                        break;

                                }

                            }
                        } while (opcionElegida > 0 && opcionElegida <= numOpciones || !salir);

                        break;
                    case "Vent":
                        do {
                            menu.menuTrabajadorComun();
                            menu.menuTrabajadorV();
                            numOpciones = 10;
                            if (userTraLogueado.isEs_jefe()) {
                                menu.funcionesJefeDepartamento();
                                numOpciones += 2;
                            }

                            System.out.println("Introduce una opción");
                            opcionElegida = scan.nextInt();

                            if (opcionElegida < 0 || opcionElegida >= numOpciones) {
                                System.out.println("Error -> Introduzca una opción válida");
                            } else {
                                switch (opcionElegida) {
                                    case 0:
                                        salir = true;
                                        break;
                                }
                            }

                        } while (opcionElegida > 0 && opcionElegida <= numOpciones || !salir);

                        break;
                    case "Comp":
                        do {
                            menu.menuTrabajadorComun();
                            menu.menuTrabajadorC();
                            numOpciones = 10;
                            if (userTraLogueado.isEs_jefe()) {
                                menu.funcionesJefeDepartamento();
                                numOpciones += 2;
                            }

                            System.out.println("Introduce una opción");
                            opcionElegida = scan.nextInt();

                            if (opcionElegida < 0 || opcionElegida >= numOpciones) {
                                System.out.println("Error -> Introduzca una opción válida");
                            } else {
                                switch (opcionElegida) {
                                    case 0:
                                        salir = true;
                                        break;
                                }
                            }
                        } while (opcionElegida > 0 && opcionElegida <= numOpciones || !salir);

                        break;
                    case "RRHH":
                        do {
                            menu.menuTrabajadorComun();
                            menu.menuTrabajadorRRHH();
                            numOpciones = 14;
                            if (userTraLogueado.isEs_jefe()) {
                                menu.funcionesJefeDepartamento();
                                numOpciones += 2;
                            }

                            System.out.println("Introduce una opción");
                            opcionElegida = scan.nextInt();

                            if (opcionElegida < 0 || opcionElegida >= numOpciones) {
                                System.out.println("Error -> Introduzca una opción válida");
                            } else {
                                switch (opcionElegida) {
                                    case 0:
                                        salir = true;
                                        break;
                                }
                            }
                        } while (opcionElegida > 0 && opcionElegida <= numOpciones || !salir);

                        break;
                }
                System.out.println("Adiós " + userTraLogueado.getUsuario());
                userTraLogueado = null;
            }

        } while (userTraLogueado == null || userCliLogueado == null);

    }

}
