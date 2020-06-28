/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import app_empresa.Empresa;
import app_empresa.Mensaje;
import app_empresa.Persona;
import app_empresa.Trabajador;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Formacion
 */
public class Menu {

    Scanner sc = new Scanner(System.in);

    public String formularioLogIn() {
        System.out.println("********************************");
        System.out.println("***   Formulario de acceso   ***");
        System.out.println("********************************");
        System.out.print("***   Usuario: ");
        String usuario = sc.nextLine();
        System.out.print("***   Password: ");
        String password = sc.nextLine();
        System.out.println("********************************");
        System.out.println();

        return usuario + "-" + password;
    }

    public void comprobarFormulario() {
        System.out.println("********************************");
        System.out.println("***  Comprobando el usuario  ***");
        System.out.println("***      y la contraseña     ***");
        System.out.println("********************************");
        System.out.println();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

    }

    public void bienvenida(Persona p) {
        System.out.println("********************************");
        if (p.getSexo() == "Hombre") {
            System.out.println("***  Bienvenido " + p.getNombre() + " ***");
        } else {
            System.out.println("***  Bienvenida " + p.getNombre() + " ***");
        }
        System.out.println("_________________________________");

    }

    public void errorFormulario() {
        System.out.println("********************************");
        System.out.println("*Usuario o contraseña no válido");
        System.out.println("*Introduzca de nuevo el usuario");

        this.formularioLogIn();
    }

    public void menuTrabajadorComun() {
        System.out.println("********************************");
        System.out.println("* 0. Salir                     ");
        System.out.println("* 1. Enviar correo a compañero ");
        System.out.println("* 2. Comprobar correo nc       ");
        System.out.println("* 3. Comprobar correo nl       ");
        System.out.println("* 4. Comprobar correo por día  ");
        System.out.println("* 5. Comprobar correo entre fechas");
        System.out.println("* 6. Enviar correo al jefe Dept");
        System.out.println("* 7. Enviar correo al jefe Emp ");
    }

    public void menuTrabajadorRRHH() {
        System.out.println("* 8. Imprimir nomina de trabajador     ");
        System.out.println("* 9. Imprimir nominas por departamento ");
        System.out.println("* 10. Imprimir informe del gasto total ");
        System.out.println("* 11. Dar de alta trabajador           ");
        System.out.println("* 12. Dar de baja lógica un trabajador ");
        System.out.println("* 13. Buscar trabajador                ");
    }

    public void menuTrabajadorAC() {
        System.out.println("* 8. Modificar cliente                      ");
        System.out.println("* 9. Imprimir ficha de cliente              ");
        System.out.println("* 10. Buscar cliente                        ");
        System.out.println("* 11. Enviar promoción a un cliente         ");
        System.out.println("* 12. Enviar promoción a todos los clientes ");
    }

    public void menuTrabajadorV() {
        System.out.println("* 8. Aplicar descuento a un producto  ");
        System.out.println("* 9. Listar pagos (orden de llegada)  ");
    }

    public void menuTrabajadorC() {
        System.out.println("* 8. Dar de alta un producto  ");
        System.out.println("* 9. Dar de baja un producto  ");
    }

    public void menuTrabajadorCyV() {
        System.out.println("* 8. Modificar cliente                      ");
        System.out.println("* 9. Imprimir ficha de cliente              ");
        System.out.println("* 10. Buscar cliente                        ");
        System.out.println("* 11. Enviar promoción a un cliente         ");
        System.out.println("* 12. Enviar promoción a todos los clientes ");
    }

    public void menuTrabajadorDireccion() {
        System.out.println("* 8. Despedir empleado                               ");
        System.out.println("* 9. Informe de ventas                               ");
        System.out.println("* 10. Informe de compras                             ");
        System.out.println("* 11. Informe de clientes                            ");
        System.out.println("* 12. Informe de personal                            ");
        System.out.println("* 13. Revisar bajas lógicas de personal              ");
        System.out.println("* 14. Revisar bajas lógicas de trabajadores por dptm ");
        System.out.println("* 15. Revisar bajas lógicas de clientes ");
        System.out.println("* 16. Subir salario ");
    }

    public void funcionesJefeDepartamento() {
        System.out.println("-------------------------------------------------");
        System.out.println("* Funciones especiales para Jefes de departamento");
        System.out.println("*  - Solicitar despido. Mediante un mensaje");
        System.out.println("*  - Solicitar subida de salario de empleado. Lo hará mediante un mensaje.");
    }

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

    public void menuCliente() {
        System.out.println("0. Salir");
        System.out.println("1. Listar artículos");
        System.out.println("2. Ver artículo");
        System.out.println("3. Comprar artículo");
        System.out.println("4. Ver tus compras");
        System.out.println("5. Lanzar hilo (Comprueba si se ha hecho un pedido)");
        System.out.println("6. Detener hilo anterior");
    }

    public static void detenerFlujo() {
        System.out.print("--- PULSE INTRO PARA CONTINUAR ---");
        try {
            System.in.read();
        } catch (IOException ex) {
        }
    }

    public int pedirOpcion() {

        Scanner scan = new Scanner(System.in);
        System.out.println("Introduce una opción");
        int opcionElegida = scan.nextInt();

        return opcionElegida;
    }
}
