/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import app_empresa.Empresa;
import app_empresa.Trabajador;
import java.util.Scanner;
import menu.Menu;
import menu.MenuLogin;
import menu.MenuTrabajadorComun;
import operaciones_trabajador.OperacionesTrabajadorComun;

/**
 *
 * @author Formacion
 */
public class SwitchTrabajadores {

    public static void switchTrabajadores(Trabajador userTraLogueado, Empresa nuevaEmpresa) {

        Scanner scan = new Scanner(System.in);
        MenuLogin ml = new MenuLogin();
        Menu menu = new Menu();
        Boolean salir = false;
        OperacionesTrabajadorComun otc = new OperacionesTrabajadorComun();
        MenuTrabajadorComun mtc = new MenuTrabajadorComun();

        int numOpciones = 0, opcionElegidaPrincipal = -1, opcionElegida = -1;
        ml.bienvenida(userTraLogueado);

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

                        salir = SwitchTrabajadorComun.switchTrabajadorComun(opcionElegida, nuevaEmpresa, userTraLogueado);

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

                        salir = SwitchTrabajadorComun.switchTrabajadorComun(opcionElegida, nuevaEmpresa, userTraLogueado);

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

                        salir = SwitchTrabajadorComun.switchTrabajadorComun(opcionElegida, nuevaEmpresa, userTraLogueado);

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

                        salir = SwitchTrabajadorComun.switchTrabajadorComun(opcionElegida, nuevaEmpresa, userTraLogueado);

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

                        salir = SwitchTrabajadorComun.switchTrabajadorComun(opcionElegida, nuevaEmpresa, userTraLogueado);

                    }
                } while (opcionElegida > 0 && opcionElegida <= numOpciones || !salir);

                break;
        }
        System.out.println("Adiós " + userTraLogueado.getUsuario());
        userTraLogueado = null;
    }

}
