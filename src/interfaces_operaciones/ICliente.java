/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces_operaciones;

import app_empresa.Cliente;

/**
 *
 * @author Formacion
 */
public interface ICliente {

    public void listarArticulos();

    public void verArticulo(int cod_articulo);

    public void comprarArticlo(Cliente c);

    public void verTusCompras(Cliente c);

    public void lanzarHilo();

    public void detenerHilo();
}
