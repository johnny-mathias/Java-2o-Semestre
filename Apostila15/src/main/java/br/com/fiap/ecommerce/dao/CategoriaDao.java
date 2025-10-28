package br.com.fiap.ecommerce.dao;

import br.com.fiap.ecommerce.exception.EntidadeNaoEncontradaException;
import br.com.fiap.ecommerce.model.Categoria;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CategoriaDao {

    @Inject
    private DataSource dataSource;

    //Implementar a pesquisa pelo código
    public Categoria buscar(int id) throws SQLException, EntidadeNaoEncontradaException {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(
                    "SELECT * FROM t_tdspv_categoria where cd_categoria = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (!rs.next())
                throw new EntidadeNaoEncontradaException("Categoria não existe");
            return parseCategoria(rs);
        }
    }

    //Função multiuso
    private static void setarParametros(Categoria categoria, PreparedStatement stmt) throws SQLException {
        stmt.setInt(1, categoria.getCodigo());
        stmt.setString(2, categoria.getNome());
    }

    //DELETE
    public void deletar(int id) throws SQLException, EntidadeNaoEncontradaException {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement("delete from " +
                    "t_tdspv_categoria where cd_categoria = ?");
            stmt.setInt(1, id);
            if (stmt.executeUpdate() == 0)
                throw new EntidadeNaoEncontradaException("Categoria não encontrado para deletá-lo");
        }
    }

    //UPDATE
    public void atualizar(Categoria categoria) throws SQLException, EntidadeNaoEncontradaException {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement("update t_tdspv_categoria set cd_categoria = ?, " +
                    "nm_categoria = ?");
            //Setar parametros
            setarParametros(categoria, stmt);
            stmt.setInt(5, categoria.getCodigo());
            //Executa a query e valida se deu certo
            if (stmt.executeUpdate() == 0)
                throw new EntidadeNaoEncontradaException("Categoria não encontrado para atualizá-lo");

        }
    }


    public List<Categoria> listar() throws SQLException {
        try (Connection connection = dataSource.getConnection()){
            PreparedStatement stmt = connection.prepareStatement("select * from t_tdspv_categoria");
            ResultSet rs = stmt.executeQuery();
            List<Categoria> lista = new ArrayList<>();
            while (rs.next()){
                Categoria categoria = parseCategoria(rs);
                lista.add(categoria);
            }
            return lista;
        }
    }

    private Categoria parseCategoria(ResultSet rs) throws SQLException {
        int codigo = rs.getInt("cd_categoria");
        String nome = rs.getString("nm_categoria");
        return new Categoria(codigo, nome);
    }

    //CREATE
    public void cadastrar(Categoria categoria) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {

            PreparedStatement stmt = connection.prepareStatement("insert into t_tdspv_categoria (cd_categoria, nm_categoria, " +
                    ") values (?, ?)", new String[] {"cd_categoria"});

            setarParametros(categoria, stmt);

            stmt.executeUpdate();

            ResultSet resultSet = stmt.getGeneratedKeys();
            if (resultSet.next()){
                categoria.setCodigo(resultSet.getInt(1));
            }
        }
    }
}
