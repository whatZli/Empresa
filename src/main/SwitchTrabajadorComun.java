/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import app_empresa.Empresa;
import app_empresa.Trabajador;
import menu.MenuTrabajadorComun;
import operaciones_trabajador.OperacionesTrabajadorComun;

/**
 *
 * @author Formacion
 */
public class SwitchTrabajadorComun {

    public static boolean switchTrabajadorComun(int opcionElegida, Empresa nuevaEmpresa, Trabajador userTraLogueado) {

        OperacionesTrabajadorComun otc = new OperacionesTrabajadorComun();
        MenuTrabajadorComun mtc = new MenuTrabajadorComun();

        switch (opcionElegida) {
            case 0:
                boolean salir = true;
                return salir;
            case 1:
                String trabajadorDestino = mtc.enviarCorreoACompañero();
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
        return false;
    }

}
