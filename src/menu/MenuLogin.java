/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import app_empresa.Persona;

/**
 *
 * @author Formacion
 */
public class MenuLogin extends Menu{

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
}
