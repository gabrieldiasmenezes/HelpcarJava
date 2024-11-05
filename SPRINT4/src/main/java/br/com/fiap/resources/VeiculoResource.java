package br.com.fiap.resources;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.fiap.beans.Veiculo;
import br.com.fiap.dao.VeiculoDao;

@Path("/veiculos")
public class VeiculoResource {

    // Inserir um novo veículo
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response inserirVeiculo(Veiculo veiculo) {
        try {
            VeiculoDao veiculoDao = new VeiculoDao();
            String resultado = veiculoDao.inserir(veiculo);
            return Response.status(Response.Status.CREATED).entity(resultado).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao inserir o veículo.").build();
        }
    }

    // Selecionar todos os veículos
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarVeiculos() {
        try {
            VeiculoDao veiculoDao = new VeiculoDao();
            List<Veiculo> listaVeiculos = veiculoDao.selecionar();
            return Response.ok(listaVeiculos).build();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao buscar os veículos.").build();
        }
    }

    // Deletar um veículo por código
    @DELETE
    @Path("/{codigo}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deletarVeiculo(@PathParam("codigo") int codigo) {
        try {
            VeiculoDao veiculoDao = new VeiculoDao();
            String resultado = veiculoDao.deletar(codigo);
            return Response.ok(resultado).build();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao deletar o veículo.").build();
        }
    }
}
