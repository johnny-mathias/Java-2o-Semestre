package br.com.fiap;

import br.com.fiap.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExemploPesquisa {
    public static void main(String[] args) {
        try {
            //Obter a conexão
            Connection connection = ConnectionFactory.getConnection();
            //Obter um statement
            Statement stm = connection.createStatement();

            //Executar comando SQL
            ResultSet rs =
                    stm.executeQuery("select * from t_produto");

            //Recuperar os dados do banco para exibir
            while (rs.next()) {
                Integer id = rs.getInt("cd_produto");
                String nome = rs.getString("nm_produto");
                String desc = rs.getString("ds_produto");
                double valor = rs.getDouble("vl_produto");

                System.out.println(id + " " + nome + " " + desc + " " + " " + valor);
            }

            //Fechar a conexão
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    } //main
} //class
