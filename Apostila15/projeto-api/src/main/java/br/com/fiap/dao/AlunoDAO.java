package br.com.fiap.dao;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import javax.sql.DataSource;

@ApplicationScoped
public class AlunoDAO {
    @Inject
    DataSource dataSource;
}