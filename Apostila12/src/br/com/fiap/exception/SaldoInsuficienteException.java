package br.com.fiap.exception;

public class SaldoInsuficienteException extends Exception {

  public SaldoInsuficienteException(String mensagem) {
    super(mensagem);
    }

  public ValorMenorQueZeroException() {
    super("Valor sei la o que");
  }
}
