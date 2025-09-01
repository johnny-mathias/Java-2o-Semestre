package br.com.fiap.util;

import br.com.fiap.exception.SaldoInsuficienteException;
import br.com.fiap.exception.ValorMenorQueZeroException;

public class Validar {

    public static void validarMaiorQueZero(double valor) throws ValorMenorQueZeroException {
        if (valor <= 0) {
            //Lançar uma Exception
            throw new ValorMenorQueZeroException("O valor deve ser maior do que zero!");
        }
    }
    /*  Esse é melhor do que o abaixo
    public static void validarContaNegativa(double saldo, double valor) throws Exception {
        if (saldo < valor) {
            //Lançar uma Exception
            throw new Exception("Você não pode retirar um valor maior que o saldo!");
        }
    }
    */
    public static void validarContaNegativa(double saldo, double valor) throws SaldoInsuficienteException {
        if (valor < 0) {
            //Lançar uma Exception
            throw new SaldoInsuficienteException("Você não pode retirar um valor maior que o saldo!");
        }
    }
}
