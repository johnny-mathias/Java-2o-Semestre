package br.com.fiap.exemplo;

import br.com.fiap.model.ContaCorrente;

import java.util.Scanner;

public class Exemplo02 {
    public static void main(String[] args) {

        //Instanciar conta corrente
        ContaCorrente cc = new ContaCorrente();

        //Instanciar o Scanner
        Scanner sc = new Scanner(System.in);

        //Criar menu
        String menu = ```Escolha:
        1-Depositar
        2-Retirar
        3-Exibir Saldo
        0-Sair```

        int opcao;
        do {
            System.out.println(menu);
            opcao = sc.nextInt();

            //Depositar um valor na conta (usuário insere o valor)
            System.out.println("Digite o valor para depositar");
            double valor = sc.nextDouble();
            cc.depositar(valor);

            //Exibir o saldo
            System.out.println("Saldo atual: " + cc.getSaldo());

            //Retirar um valor da conta (usuário insere o valor)
            System.out.println("Digite o valor para retirada");
            valor = sc.nextDouble();
            cc.retirar(valor);

            //Exibir o saldo
            System.out.println("Saldo atual: " + cc.getSaldo());
        } while(opcao != 0);

    }//main
}//class