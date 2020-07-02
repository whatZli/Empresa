/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaciones_trabajador;

import app_empresa.Departamento;
import app_empresa.Empresa;
import app_empresa.Mensaje;
import app_empresa.Trabajador;
import interfaces_operaciones.IDepComun;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import menu.Menu;
import menu.MenuTrabajadorComun;

/**
 *
 * @author Formacion
 */
public class OperacionesTrabajadorComun implements IDepComun {

    MenuTrabajadorComun mtc = new MenuTrabajadorComun();

    //Método que devuelve un trabajador si lo encuentra en algún departamento de la empresa
    //sino lo encuentra devuelve null
    public Trabajador comprobarUsuarioExiste(Empresa empresa, String codigoUsuario) {
        String claveDept;
        Iterator<String> departamentos = empresa.getDepartamentos().keySet().iterator();
        while (departamentos.hasNext()) {
            claveDept = departamentos.next();
            Departamento d = empresa.getDepartamentos().get(claveDept);

            String clave;
            Iterator<String> trabajadores = d.getListaTrabajadores().keySet().iterator();
            while (trabajadores.hasNext()) {
                clave = trabajadores.next();
                if (clave.equals(codigoUsuario)) {
                    Trabajador t = d.getListaTrabajadores().get(clave);
                    return t;
                }
            }
        }

        return null;
    }

    @Override
    public void enviarCorreo(Empresa nuevaEmpresa, String tDestino, Trabajador tOrigen) {
        Trabajador trabajadorEnviarEmail = this.comprobarUsuarioExiste(nuevaEmpresa, tDestino);
        if (trabajadorEnviarEmail != null) {
            Mensaje m = mtc.escribirMensaje(tOrigen);
            trabajadorEnviarEmail.addMensaje(m);
            System.out.println("--- Mensaje enviado");
        } else {
            System.out.println("--- El trabajador no existe");
        }
    }

    @Override
    public int checkCorreoNoContestado(Trabajador tOrigen, Empresa nuevaEmpresa) {
        Scanner scan = new Scanner(System.in);

        int menuComprobarNC = -1;
        do {
            int cont = 1;

            LinkedList<Mensaje> listaMensajes = tOrigen.getMensajes();

            System.out.println("---------------------------------");
            listaMensajes = tOrigen.getMensajes();
            System.out.println("--- Listado de correos No Contestados ");
            if (listaMensajes.isEmpty()) {
                System.out.println("--- Bandeja vacía");
                System.out.println("--- Introduce 0 para salir");
                menuComprobarNC = scan.nextInt();
            } else {
                for (Mensaje m : listaMensajes) {
                    if (m.isContestado() == false) {
                        System.out.println("* " + cont++ + ". Origen: " + m.gettOrigen().getUsuario() + " - Fecha - " + m.getFecha() + " - Hora - " + m.getHora() + " - " + m.getAsunto());
                    }
                }
                System.out.println("--- Introduce el número de mensaje que quieres contestar (0 para salir)");
                menuComprobarNC = scan.nextInt();
                if (menuComprobarNC > 0 && menuComprobarNC < cont) {
                    Mensaje m = listaMensajes.get(menuComprobarNC - 1);
                    System.out.println("--------------------------------------");
                    System.out.println("| Origen: " + m.gettOrigen().getUsuario() + "      Fecha:" + m.getFecha() + " " + m.getHora());
                    System.out.println("| Asunto: " + m.getAsunto());
                    System.out.println("| Mensaje: " + m.getCuerpo());
                    System.out.println("---|");
                    System.out.println("   |");
                    m.setContestado(true);

                    String tDestino = mtc.responderCorreoACompañero(m.gettOrigen().getUsuario());
                    this.enviarCorreo(nuevaEmpresa, tDestino, tOrigen);

                    System.out.println("");
                }
            }

            System.out.println("---------------------------------");
        } while (menuComprobarNC != 0);

        return menuComprobarNC;
    }

    @Override
    public int checkCorreoNoLeido(Trabajador tOrigen) {
        Scanner scan = new Scanner(System.in);

        int cont = 1;
        int menuComprobarNL = -1;

        System.out.println("---------------------------------");

        LinkedList<Mensaje> listaMensajes = tOrigen.getMensajes();
        listaMensajes = tOrigen.getMensajes();
        System.out.println("--- Listado de correos No Leídos ");
        if (listaMensajes.isEmpty()) {//Error aquí. la lista puede contener mensajes aunque estén leidos y no entra en el if
            System.out.println("--- Bandeja vacía");
            System.out.println("--- Introduce el número de mensaje que quieres leer (0 para salir)");
            menuComprobarNL = scan.nextInt();
        } else {
            for (Mensaje m : listaMensajes) {
                if (m.isLeido() == false) {
                    System.out.println("* " + cont++ + ". Origen: " + m.gettOrigen().getUsuario() + " - Fecha - " + m.getFecha() + " - Hora - " + m.getHora() + " - " + m.getAsunto());
                }
            }
        }
        System.out.println("--- Introduce el número de mensaje que quieres leer (0 para salir)");
        menuComprobarNL = scan.nextInt();
        if (menuComprobarNL > 0 && menuComprobarNL < cont) {
            Mensaje m = listaMensajes.get(menuComprobarNL - 1);
            System.out.println("--------------------------------------");
            System.out.println("| Origen: " + m.gettOrigen().getUsuario() + "      Fecha:" + m.getFecha() + " " + m.getHora());
            System.out.println("| Asunto: " + m.getAsunto());
            System.out.println("| Mensaje: " + m.getCuerpo());
            m.setLeido(true);
        }

        Menu.detenerFlujo();

        return menuComprobarNL;
    }

    @Override
    public void checkCorreoDiaConcreto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void checkCorreoEntreFechas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enviarCorreoJefeDept() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enviarCorreoJefeEmp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
