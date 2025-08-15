package br.com.fiap.exemplo01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exemplo02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Criar uma lista de frutas
        String nome;
        String cor;
        double preco;

        List<br.com.fiap.model.Fruta> frutas = new ArrayList<>();

        //Pedir para o usuário inserir uma fruta na lista
        System.out.println("Digite o nome do fruta: ");
        nome = scanner.next() + scanner.nextLine();

        System.out.println("Digite o cor do fruta: ");
        cor = scanner.next() + scanner.nextLine();

        System.out.println("Digite o preço do fruta: ");
        preco = scanner.nextDouble();
        scanner.nextLine();

        Fruta fruta = new Fruta(nome, cor, preco);

        frutas.add(fruta);

        //Exibir  todas as frutas da lista

    }
}
