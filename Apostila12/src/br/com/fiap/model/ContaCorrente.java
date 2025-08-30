package br.com.fiap.model;

import br.com.fiap.util.Validar;

public class ContaCorrente {

    private double saldo;

    //Criar o método depositar
    public void depositar(double valor) throws Exception {
        Validar.validarMaiorQueZero(valor);
        saldo += valor;
    }

    //Criar o método retirar
    public void retirar(double valor) throws Exception{
        Validar.validarMaiorQueZero(valor);
        Validar.validarContaNegativa(saldo, valor);
        saldo -= valor;
    }

    //Criar o método retornar saldo
    public double getSaldo(){
        return saldo;
    }

}
