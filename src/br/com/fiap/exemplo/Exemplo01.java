package br.com.fiap.exemplo;

import java.util.ArrayList;
import java.util.List;

public class Exemplo01 {

    public static void main(String[] args) {
        //Lista de Nomes de Frutas
        List<String> frutas = new ArrayList<>();
        frutas.add("Manga");
        frutas.add("Uva");
        frutas.add("Abacaxi");

        //Exibir a quantidade de frutas na lista
        System.out.println("Quantidade: " + frutas.size());

        //Exibir o valor da primeira posição da lista
        System.out.println("Valor da primeira posição: " + frutas.get(0));

        //Adicionar uma fruta na segunda opção
        frutas.add(2,"Morango");

        //Remover a uva da lista
        frutas.remove(1);


        //Exibir todos os elementos da lista (Posição - Valor )
        for (int i = 0; i < frutas.size(); i++) {
            System.out.println("Posição: " + i + " " + frutas.get(i));

        }



    }
}
