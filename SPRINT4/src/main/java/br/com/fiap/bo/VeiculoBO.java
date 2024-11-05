package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import br.com.fiap.beans.Cliente;
import br.com.fiap.beans.Veiculo;
import br.com.fiap.dao.VeiculoDao;

public class VeiculoBO {
    private VeiculoDao veiculoDao;
    private Random random;

    public VeiculoBO() throws ClassNotFoundException, SQLException {
        this.veiculoDao = new VeiculoDao();
        this.random = new Random(); // Inicializa o gerador de números aleatórios
    }

    public String adicionarVeiculo(Cliente cliente, Veiculo veiculo) throws Exception {
        // Verifica se o cliente está autenticado ou se os dados do cliente são válidos
        if (cliente == null || veiculo == null) {
            throw new Exception("Dados inválidos.");
        }

        // Obtém a lista de veículos do cliente utilizando o CPF do cliente
        List<Veiculo> veiculos = veiculoDao.selecionarPorCpf(cliente.getCpf());

        // Verifica se o cliente já possui 5 veículos
        if (veiculos.size() >= 5) {
            throw new Exception("Você já possui 5 veículos cadastrados. Não é possível adicionar mais.");
        }

        // Gera um código aleatório de até 6 dígitos e define no veículo
        int codigoVeiculo = gerarCodigoAleatorio(6);
        veiculo.setCodigo(codigoVeiculo); // Presumindo que Veiculo tenha um método setCodigo

        // Define o CPF do cliente no veículo
        veiculo.setCpfCliente(cliente.getCpf());

        // Chama o DAO para inserir o veículo
        return veiculoDao.inserir(veiculo);
    }

    private int gerarCodigoAleatorio(int numDigitos) {
        int limiteSuperior = (int) Math.pow(10, numDigitos); // Limite superior para o número de dígitos
        return random.nextInt(limiteSuperior); // Gera um número aleatório dentro do limite
    }
}
