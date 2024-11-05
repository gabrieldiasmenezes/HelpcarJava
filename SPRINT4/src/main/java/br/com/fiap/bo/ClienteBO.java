package br.com.fiap.bo;

import java.sql.SQLException;

import br.com.fiap.beans.Cliente;
import br.com.fiap.dao.ClienteDao;
import br.com.fiap.model.Endereco; // Certifique-se de que a classe Endereco está importada
import br.com.fiap.service.ViaCepService; // Certifique-se de que o ViaCepService está importado

public class ClienteBO {
    private ClienteDao clienteDao;
    private ViaCepService viaCepService; // Adicionando o serviço ViaCep

    public ClienteBO() throws ClassNotFoundException, SQLException {
        this.clienteDao = new ClienteDao();
        this.viaCepService = new ViaCepService(); // Inicializando o serviço
    }

    public String criarPerfil(Cliente cliente) throws Exception {
        // Verifica se a idade do cliente é igual ou acima de 18
        if (cliente.getIdade() < 18) {
            throw new Exception("Idade deve ser igual ou acima de 18 anos.");
        }

        // Verifica se o CPF tem 11 dígitos
        if (cliente.getCpf() == null || cliente.getCpf().length() != 11) {
            throw new Exception("CPF deve ter 11 dígitos.");
        }

        // Verifica se a senha tem 10 caracteres
        if (cliente.getSenha() == null || cliente.getSenha().length() != 10) {
            throw new Exception("A senha deve ter 10 caracteres.");
        }

        // Obtém o endereço usando o CEP fornecido
        Endereco endereco = viaCepService.getEndereco(cliente.getEndereco()); // 
        String enderecoFormatado = endereco.formatarEndereco(); // Formata o endereço

        cliente.setEndereco(enderecoFormatado); // Armazenando o endereço formatado no cliente

        // Chama o DAO para inserir o cliente
        return clienteDao.inserir(cliente);
    }
}
