/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_empresa;

import java.util.HashMap;

/**
 *
 * @author Formacion
 */
public class Cliente extends Persona {

    private String cod_cliente;
    private String password;//Campo añadido a mayores para hacer el login
    private int p_acumulado;
    private float saldo;

    private enum categoria {
        normal, premium
    };

    public Cliente(String cod_cliente, String password, int p_acumulado, float saldo, String nombre, String apellido1, String apellido2, String dni, String email, String sexo, String f_alta, String f_baja, boolean activo) {
        super(nombre, apellido1, apellido2, dni, email, sexo, f_alta, f_baja, activo);
        this.cod_cliente = cod_cliente;
        this.password = password;
        this.p_acumulado = p_acumulado;
        this.saldo = saldo;

    }

    public String getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(String cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public int getP_acumulado() {
        return p_acumulado;
    }

    public void setP_acumulado(int p_acumulado) {
        this.p_acumulado = p_acumulado;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
