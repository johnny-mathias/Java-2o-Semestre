package br.com.fiap.exemplo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exemplo01 {

    public static void main(String[] args) {
        //Ler dois numeros
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Numero 1: ");
            int n1 = sc.nextInt();

            System.out.println("Numero 2: ");
            int n2 = sc.nextInt();

            int divisao = n1/n2;
            System.out.println(n1 + "/" + n2 + " = " + divisao);

        } catch (InputMismatchException e) {
            //Tratamento da Exception
            System.err.println("Digite um valor válido na próxima vez!");
        } catch (ArithmeticException e) {
            System.err.println("Não é possível dividir por zero!");
        } finally {
            sc.close();
        }



    }
}
