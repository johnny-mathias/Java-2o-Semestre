package br.com.fiap.ecommerce.resource;

import br.com.fiap.bean.ModelMapperProducer;
import br.com.fiap.ecommerce.dao.ProdutoDao;
import br.com.fiap.ecommerce.dto.produto.CadastrarProdutoDto;
import br.com.fiap.ecommerce.dto.produto.DetalhesProdutoDto;
import br.com.fiap.ecommerce.exception.EntidadeNaoEncontradaException;
import br.com.fiap.ecommerce.model.Produto;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import org.modelmapper.ModelMapper;

import java.net.URI;
import java.sql.SQLException;
import java.util.List;

@Path("/produtos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProdutoResource {

    @Inject
    private ProdutoDao produtoDao;

    @Inject
    private ModelMapper modelMapper;

    @DELETE
    @Path("/{id}")
    public Response deletar (int codigo) throws SQLException, EntidadeNaoEncontradaException {
        produtoDao.deletar(codigo);
        return Response.noContent().build();
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") int codigo, Produto produto) throws EntidadeNaoEncontradaException, SQLException {
        produto.setCodigo(codigo);
        produtoDao.atualizar(produto);
        return Response.noContent().build();
    }

    @GET
    @Path("/{id}")
    public Response buscar(@PathParam("id") int codigo) throws SQLException, EntidadeNaoEncontradaException {
        DetalhesProdutoDto dto = modelMapper
                .map(produtoDao.buscar(codigo), DetalhesProdutoDto.class);
        return Response.ok(produtoDao.buscar(codigo)).build();
    }

    @GET
    public List<Produto> listar() throws SQLException {
        return produtoDao.listar();
    }

    @POST
    public Response create(CadastrarProdutoDto dto, @Context UriInfo uriInfo) throws SQLException {
        Produto produto = modelMapper.map(dto, Produto.class);
        produtoDao.cadastrar(produto);

        //Constroi uma URL de retorno, para acessar o recurso criado
        URI uri = uriInfo.getAbsolutePathBuilder()
                .path(String.valueOf(produto.getCodigo())).build();

        return Response.created(uri).entity(modelMapper.map(produto, DetalhesProdutoDto.class)).build(); //HTTP STATUS CODE 201 (Created)
    }

}
