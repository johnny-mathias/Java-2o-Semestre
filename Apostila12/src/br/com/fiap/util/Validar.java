package br.com.fiap.util;

public class Validar {

    public static void validarMaiorQueZero(double valor) throws Exception {
        if (valor <= 0) {
            //Lançar uma Exception
            throw new Exception("O valor deve ser maior do que zero!");
        }
    }
    public static void validarContaNegativa(double saldo, double valor) throws Exception {
        if (saldo < valor) {
            //Lançar uma Exception
            throw new Exception("Você não pode retirar um valor maior que o saldo!");
        }
    }
}
