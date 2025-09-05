package br.com.fiap.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        //Obter conexão com o banco de dados
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conexao = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "rm566516", "210806");

        System.out.println("Conectado com sucesso!");

        return conexao;

    }
}