/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import app_empresa.Mensaje;
import app_empresa.Trabajador;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Formacion
 */
public class MenuTrabajadorComun extends Menu{
    
    public String enviarCorreoACompañero() {
        System.out.println("-------------------------------------------------");
        System.out.println("--- Enviar correo a compañero");
        System.out.println();
        System.out.println("--- Introduzca el usuario al que");
        System.out.println("---   se le enviará el mensaje");
        System.out.print("--- Usuario: ");
        String usuario = sc.nextLine();
        return usuario;
    }

    public String responderCorreoACompañero(String tDestino) {
        System.out.println("--- Responder correo a compañero");
        System.out.print("--- Origen: " + tDestino);
        return tDestino;
    }

    public Mensaje escribirMensaje(Trabajador tOrigen) {
        Date d = new Date();
        SimpleDateFormat formatterFecha = new SimpleDateFormat("yyyy-MM-dd");
        String fechaActual = formatterFecha.format(d);
        SimpleDateFormat formatterHora = new SimpleDateFormat("HH:mm:ss");
        String horaActual = formatterHora.format(d);

        System.out.println(" - Día-> " + fechaActual + " - Hora-> " + horaActual);

        System.out.println("-------------------------------------------------");
        System.out.println("--- Escribir mensaje");
        System.out.print("--- Asunto: ");
        String asunto = sc.nextLine();
        System.out.print("--- Cuerpo: ");
        String cuerpo = sc.nextLine();

        Mensaje m = new Mensaje(tOrigen, fechaActual, horaActual, asunto, cuerpo, false, false);
        return m;
    }
    
}
