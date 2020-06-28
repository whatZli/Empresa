/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces_operaciones;

import app_empresa.Empresa;
import app_empresa.Trabajador;

/**
 *
 * @author Formacion
 */
public interface IDepComun {

    public void enviarCorreo(Empresa nuevaEmpresa, String tDestino, Trabajador tOrigen);

    public int checkCorreoNoContestado(Trabajador t, Empresa nuevaEmpresa);

    public int checkCorreoNoLeido(Trabajador t);

    public void checkCorreoDiaConcreto();

    public void checkCorreoEntreFechas();

    public void enviarCorreoJefeDept();

    public void enviarCorreoJefeEmp();

}
