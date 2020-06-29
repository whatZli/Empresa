/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import app_empresa.Cliente;
import hilos.AvisadorMovimientoBD;
import menu.Menu;
import menu.MenuCliente;
import menu.MenuLogin;
import operaciones_cliente.OperacionesCliente;

/**
 *
 * @author Formacion
 */
public class SwitchClientes {

    public static void switchClientes(Cliente userCliLogueado) {

        MenuCliente menuCliente = new MenuCliente();
        MenuLogin ml = new MenuLogin();
        OperacionesCliente oc = new OperacionesCliente();
        //Hilos
        AvisadorMovimientoBD avbd = new AvisadorMovimientoBD();
        Thread t1 = new Thread(avbd);

        int opcionElegida = -1;
        ml.bienvenida(userCliLogueado);
        do {
            menuCliente.menuPrincipalCliente();

            opcionElegida = menuCliente.pedirOpcion();

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
                    System.out.println("--- Hilo lanzado");
                    t1.start();
                    break;
                case 6:
                    System.out.println("--- Hilo parado");
                    avbd.detenElHilo();
                    break;
            }
        } while (opcionElegida != 0);
    }
}
