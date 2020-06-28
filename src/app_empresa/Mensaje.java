/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_empresa;

import java.util.Date;

/**
 *
 * @author Formacion
 */
public class Mensaje {

    private Trabajador tOrigen;//Propiedad añadida para después poder obtener quién envió el mensaje
    private String fecha;
    private String hora;
    private String asunto;
    private String cuerpo;
    private boolean leido;
    private boolean contestado;

    public Mensaje(Trabajador tOrigen, String fecha, String hora, String asunto, String cuerpo, boolean leido, boolean contestado) {
        this.tOrigen = tOrigen;
        this.fecha = fecha;
        this.hora = hora;
        this.asunto = asunto;
        this.cuerpo = cuerpo;
        this.leido = leido;
        this.contestado = contestado;
    }

    public Trabajador gettOrigen() {
        return tOrigen;
    }

    public void settOrigen(Trabajador tOrigen) {
        this.tOrigen = tOrigen;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public boolean isLeido() {
        return leido;
    }

    public void setLeido(boolean leido) {
        this.leido = leido;
    }

    public boolean isContestado() {
        return contestado;
    }

    public void setContestado(boolean contestado) {
        this.contestado = contestado;
    }

}
