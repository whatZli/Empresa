/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

import app_empresa.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import menu.Menu;

/**
 *
 * @author Formacion
 */
public class ComprobarValidezPedido implements Runnable {

    boolean confirmacion = false;
    Connection con;
    Cliente c;
    int codArticuloComprar;
    int cantidadComprar;

    synchronized public void hacerPedido() throws InterruptedException {
        System.out.println("Esperando confirmación...");

        wait();//Bloquea el hilo hasta que el siguiente método no le de confirmación

        if (confirmacion) {
            try {

                String consulta = "INSERT INTO `pedido` (`cod_pedido`, `cod_cliente`,  `cod_producto`,`cantidad`) VALUES (NULL, ?, ?,?);";
                PreparedStatement ps = con.prepareStatement(consulta);

                ps.setString(1, this.c.getCod_cliente());
                ps.setInt(2, this.codArticuloComprar);
                ps.setInt(3, this.cantidadComprar);

                int row = ps.executeUpdate();

                // rows affected
                System.out.println("Se ha comprado el producto correctamente"); //1

                ps.close();

            } catch (Exception ex) {
                Logger.getLogger(ComprobarValidezPedido.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        System.out.println("Final de la compra");

        //Conexion.desconectar();
        Menu.detenerFlujo();
    }

    synchronized public void confirmacion() throws InterruptedException {
        System.out.println("Pedido confirmado");
        this.confirmacion = true;

        notify();//Despierta el hilo anterior para seguir ejecutandolo

    }

    @Override
    public void run() {
        try {
            this.hacerPedido();
        } catch (InterruptedException ex) {
            Logger.getLogger(ComprobarValidezPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getCodArticuloComprar() {
        return codArticuloComprar;
    }

    public void setCodArticuloComprar(int codArticuloComprar) {
        this.codArticuloComprar = codArticuloComprar;
    }

    public int getCantidadComprar() {
        return cantidadComprar;
    }

    public void setCantidadComprar(int cantidadComprar) {
        this.cantidadComprar = cantidadComprar;
    }

    public Cliente getC() {
        return c;
    }

    public void setC(Cliente c) {
        this.c = c;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
}
