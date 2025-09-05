package br.com.fiap;

import br.com.fiap.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class AtualizarProduto {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Connection conexao = ConnectionFactory.getConnection();

        int cd_produto = 0;

        System.out.println("Digite o nome do produto: ");
        String nome = sc.nextLine();

        System.out.println("Adicionar código Automaticamente ou Manualmente? (A/M): ");
        if (sc.nextLine().equalsIgnoreCase("A")) {
            cd_produto += 1;
        } else if (sc.nextLine().equalsIgnoreCase("M")) {
            System.out.println("Digite o código do produto: ");
            cd_produto = sc.nextInt();
            sc.nextLine();
        }

        System.out.println("Digite a descrição do produto: ");
        String ds_produto = sc.nextLine();

        System.out.println("Digite o valor do produto: ");
        double valor = sc.nextDouble();
        sc.nextLine();

        //Criar um objeto Statment
        Statement stm = conexao.createStatement();

        //Inserir um produto no banco de dados
        stm.executeUpdate("INSERT INTO t_produto (cd_produto, nm_produto, ds_produto, vl_produto)" +
                "VALUES (cd_produto, 'nm_produto', 'ds_produto', vl_produto)");


    }
}
