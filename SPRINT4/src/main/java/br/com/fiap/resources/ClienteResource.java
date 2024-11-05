package br.com.fiap.resources;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import br.com.fiap.beans.Cliente;
import br.com.fiap.bo.ClienteBO;
import br.com.fiap.model.Endereco;
import br.com.fiap.service.ViaCepService;

@Path("/clientes")
public class ClienteResource {

    @POST
    @Consumes("application/json")
    public Response criarCliente(Cliente cliente) {
        try {
            // Usar o ViaCepService para obter o endereço usando o CEP do cliente
            ViaCepService viaCepService = new ViaCepService();
            Endereco endereco = viaCepService.getEndereco(cliente.getEndereco());

            // Verifique se o endereço foi retornado com sucesso
            if (endereco == null) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("CEP não encontrado.")
                        .build();
            }

            // Criar um objeto Endereco com os dados necessários
            // (Se você já tem o objeto Endereco completo, isso pode ser ajustado)
            String enderecoCompleto = String.join(", ", 
                endereco.getLogradouro(), 
                endereco.getComplemento(), 
                endereco.getBairro(), 
                endereco.getLocalidade(), 
                endereco.getUf()
            );

            // Definir o endereço formatado no cliente
            cliente.setEndereco(enderecoCompleto);

            // Criar perfil do cliente através do BO
            ClienteBO clienteBO = new ClienteBO();
            String resultado = clienteBO.criarPerfil(cliente);

            return Response.status(Response.Status.CREATED)
                    .entity(resultado)
                    .build();

        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao conectar ao banco de dados.")
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        }
    }
}
