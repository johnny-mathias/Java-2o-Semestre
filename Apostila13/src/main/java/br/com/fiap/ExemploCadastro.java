package br.com.fiap;

import br.com.fiap.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class ExemploCadastro {

    public static void main(String[] args) {

        try {
            //Obter conexão com o banco de dados
            Connection conexao = ConnectionFactory.getConnection();


            //Criar um objeto Statment
            Statement stm = conexao.createStatement();

            //Inserir um produto no banco de dados
            stm.executeUpdate("INSERT INTO t_produto (cd_produto, nm_produto, ds_produto, vl_produto) VALUES (123456, 'Massa de churros', 'Massa para fazer churros', 12.98)");

            //Fecha a conexao
            conexao.close();


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    } //main
} // class