package br.com.fiap;

import br.com.fiap.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ExemploRemocao {

    public static void main(String[] args) {
        try {
            //Obter a conexão com o banco dados
            Connection churros = ConnectionFactory.getConnection();
            //Obter um Statement
            Statement stm = churros.createStatement();
            //Executar o comando SQL
            stm.executeUpdate("delete from t_produto " +
                    "where cd_produto = 1");
            //Fechar a conexão
            churros.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    } //main
} //class
