package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.fiap.beans.Veiculo;
import br.com.fiap.conexoes.ConexaoFactory;

public class VeiculoDao {
    private Connection minhaConexao;

    public VeiculoDao() throws ClassNotFoundException, SQLException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Método para inserir um veículo
    public String inserir(Veiculo veiculo) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("INSERT INTO VEICULO (codigo, marca, modelo, ano, placa, cpf_cliente) VALUES (?, ?, ?, ?, ?, ?)");
        stmt.setInt(1, veiculo.getCodigo());
        stmt.setString(2, veiculo.getMarca());
        stmt.setString(3, veiculo.getModelo());
        stmt.setInt(4, veiculo.getAno());
        stmt.setString(5, veiculo.getPlaca());
        stmt.setString(6, veiculo.getCpfCliente()); // Adiciona o CPF do cliente
        stmt.execute();
        stmt.close();
        return "Veículo cadastrado com sucesso!";
    }

    // Método para deletar um veículo
    public String deletar(int codigo) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("DELETE FROM VEICULO WHERE codigo = ?");
        stmt.setInt(1, codigo);
        stmt.execute();
        stmt.close();
        return "Veículo deletado com sucesso!";
    }

    // Método para selecionar todos os veículos
    public List<Veiculo> selecionar() throws SQLException {
        List<Veiculo> listaVeiculo = new ArrayList<>();
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM VEICULO");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Veiculo veiculo = new Veiculo();
            veiculo.setCodigo(rs.getInt(1));
            veiculo.setMarca(rs.getString(2));
            veiculo.setModelo(rs.getString(3));
            veiculo.setAno(rs.getInt(4));
            veiculo.setPlaca(rs.getString(5));
            veiculo.setCpfCliente(rs.getString(6)); // Assume que você armazenou o CPF
            listaVeiculo.add(veiculo);
        }
        return listaVeiculo;
    }

    // Método para selecionar veículos por CPF do cliente
    public List<Veiculo> selecionarPorCpf(String cpf) throws SQLException {
        List<Veiculo> listaVeiculos = new ArrayList<>();
        String sql = "SELECT * FROM VEICULO WHERE cpf_cliente = ?"; // Adapte a consulta ao nome real da tabela e colunas
        PreparedStatement stmt = minhaConexao.prepareStatement(sql);
        stmt.setString(1, cpf);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Veiculo veiculo = new Veiculo();
            veiculo.setCodigo(rs.getInt("codigo")); // Adapte conforme a sua estrutura
            veiculo.setMarca(rs.getString("marca")); // Adapte conforme a sua estrutura
            veiculo.setModelo(rs.getString("modelo")); // Adapte conforme a sua estrutura
            veiculo.setAno(rs.getInt("ano")); // Adapte conforme a sua estrutura
            veiculo.setPlaca(rs.getString("placa")); // Adapte conforme a sua estrutura
            veiculo.setCpfCliente(rs.getString("cpf_cliente")); // Adicione o CPF do cliente
            listaVeiculos.add(veiculo);
        }

        rs.close();
        stmt.close();
        return listaVeiculos;
    }

    // Outros métodos da classe VeiculoDao...
}
