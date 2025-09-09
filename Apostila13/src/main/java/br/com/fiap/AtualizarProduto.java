package br.com.fiap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AtualizarProduto {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Connection conexao = null;

        try {
            // Conectar ao banco Oracle
            conexao = ConnectionFactory.getConnection();

            PreparedStatement pst = null;

            int cd_produto = 0;

            // Solicitar o nome do produto
            System.out.println("Digite o nome do produto: ");
            String nome = sc.nextLine();

            // Perguntar se o código do produto será automático ou manual
            System.out.println("Adicionar código Automaticamente ou Manualmente? (A/M): ");
            if (sc.nextLine().equalsIgnoreCase("A")) {
                cd_produto += 1; // Código automático
            } else if (sc.nextLine().equalsIgnoreCase("M")) {
                // Solicitar o código manualmente
                System.out.println("Digite o código do produto: ");
                cd_produto = sc.nextInt();
                sc.nextLine();  // Limpar o buffer após nextInt()
            }

            // Solicitar a descrição do produto
            System.out.println("Digite a descrição do produto: ");
            String ds_produto = sc.nextLine();

            // Solicitar o valor do produto
            System.out.println("Digite o valor do produto: ");
            double valor = sc.nextDouble();
            sc.nextLine(); // Limpar o buffer após nextDouble()

            // SQL parametrizado para evitar SQL Injection
            String sql = "INSERT INTO t_produto (cd_produto, nm_produto, ds_produto, vl_produto) VALUES (?, ?, ?, ?)";

            // Preparar o comando SQL
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, cd_produto);  // Substituir o primeiro parâmetro (código do produto)
            pst.setString(2, nome);      // Substituir o segundo parâmetro (nome do produto)
            pst.setString(3, ds_produto); // Substituir o terceiro parâmetro (descrição do produto)
            pst.setDouble(4, valor);     // Substituir o quarto parâmetro (valor do produto)

            // Executar o comando de inserção
            pst.executeUpdate();

            System.out.println("Produto inserido com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fechar os recursos
            try {
                if (conexao != null) conexao.close();
                sc.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

class ConnectionFactory {
    public static Connection getConnection() throws SQLException {
        try {
            // Carregar o driver Oracle (necessário dependendo da versão do Oracle)
            Class.forName("oracle.jdbc.OracleDriver");

            // Conexão com o banco Oracle
            return DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:XE",  // Ajuste a URL conforme seu banco Oracle
                    "usuario",  // Substitua pelo seu nome de usuário
                    "senha"     // Substitua pela sua senha
            );
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("Driver JDBC Oracle não encontrado.");
        }
    }
}
