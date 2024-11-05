package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.fiap.beans.Cliente;
import br.com.fiap.conexoes.ConexaoFactory;

public class ClienteDao {
	
	public Connection minhaConexao;
	
	public ClienteDao() throws ClassNotFoundException, SQLException {
		super();
		this.minhaConexao = new ConexaoFactory().conexao();
	}
	
	// Insert 
	public String inserir (Cliente cliente) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement
				(" Insert into USUARIO values (?, ?, ?, ?, ?, ?, ?)");
			stmt.setString(1, cliente.getCpf());
			stmt.setString(2, cliente.getNome());
			stmt.setString(3, cliente.getEmail());
			stmt.setString(4, cliente.getEndereco());
			stmt.setString(5, cliente.getTelefone());
			stmt.setInt(6, cliente.getIdade());
			stmt.setString(7, cliente.getSenha());			
			stmt.execute();
			stmt.close();			
		return "Cadastro realizado com Sucesso!";
	}
	
	// Delete
	public String deletar(String cpf) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement
				("Delete from USUARIO where cpf = ?");
			stmt.setString(1, cpf);
			stmt.execute();
			stmt.close();		
		return "Conta deletada com Sucesso!";
	}

	// Select 
	public List<Cliente> selecionar() throws SQLException{
		List<Cliente> listaCliente = new ArrayList<Cliente>();
		PreparedStatement stmt = minhaConexao.prepareStatement
				("SELECT * FROM USUARIO");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setCpf(rs.getString(1));
				cliente.setNome(rs.getString(2));
				cliente.setEmail(rs.getString(3));
				cliente.setEndereco(rs.getString(4));
				cliente.setTelefone(rs.getString(5));
				cliente.setIdade(rs.getInt(6));
				cliente.setSenha(rs.getString(7));
				listaCliente.add(cliente);
			}		
		return listaCliente;		
	}
	

}
