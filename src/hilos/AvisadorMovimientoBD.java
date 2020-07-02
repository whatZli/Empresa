/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

import db.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Formacion
 */
public class AvisadorMovimientoBD implements Runnable {

    private int elementos;
    // boolean que pondremos a false cuando queramos parar el hilo
    private static volatile boolean continuar;

    @Override
    public void run() {
        continuar = true;
        
        Connection con = Conexion.getConexion();

        try {
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select count(*) from pedido");

            if (rs.next()) {
                elementos = rs.getInt(1);
            }

            if (con == null) {
                //** Operaciones
                System.out.println("Conexion no realizada");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        while (con != null && continuar) {

            try {
                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select count(*) from pedido");

                if (rs.next()) {
                    if (rs.getInt(1) != elementos) {
                        System.out.println("HILO - El hilo creado ha encontrado una nueva compra");
                        elementos = rs.getInt(1);
                    }
                }

                if (con != null) {
                    //** Operaciones

                } else {
                    System.out.println("Conexion no realizada");
                }
            } catch (Exception e) {
                System.out.println(e);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

        }

    }

    // metodo para poner el boolean a false.
    public void detenElHilo() {
        continuar = false;
    }

}
