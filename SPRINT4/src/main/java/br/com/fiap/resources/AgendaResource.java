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

import br.com.fiap.beans.Agenda;
import br.com.fiap.dao.AgendaDao;

@Path("/agendamentos")
public class AgendaResource {


    // Inserir um novo agendamento
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response inserirAgendamento(Agenda agenda) {
        try {
            AgendaDao agendaDao = new AgendaDao();
            String resultado = agendaDao.inserir(agenda);
            return Response.status(Response.Status.CREATED).entity(resultado).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao inserir o agendamento.").build();
        }
    }

    // Selecionar todos os agendamentos
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarAgendamentos() {
        try {
            AgendaDao agendaDao = new AgendaDao();
            List<Agenda> listaAgendamentos = agendaDao.selecionar();
            return Response.ok(listaAgendamentos).build();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao buscar os agendamentos.").build();
        }
    }

    // Deletar um agendamento por código
    @DELETE
    @Path("/{codigo}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deletarAgendamento(@PathParam("codigo") int codigo) {
        try {
            AgendaDao agendaDao = new AgendaDao();
            String resultado = agendaDao.deletar(codigo);
            return Response.ok(resultado).build();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao deletar o agendamento.").build();
        }
    }
}
