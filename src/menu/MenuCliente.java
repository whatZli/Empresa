/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import java.util.Scanner;

/**
 *
 * @author Formacion
 */
public class MenuCliente extends Menu{

    public MenuCliente() {
    }
    
    public void menuPrincipalCliente() {
        System.out.println("0. Salir");
        System.out.println("1. Listar artículos");
        System.out.println("2. Ver artículo");
        System.out.println("3. Comprar artículo");
        System.out.println("4. Ver tus compras");
        System.out.println("5. Lanzar hilo (Comprueba si se ha hecho un pedido)");
        System.out.println("6. Detener hilo anterior");
    }
    
}
