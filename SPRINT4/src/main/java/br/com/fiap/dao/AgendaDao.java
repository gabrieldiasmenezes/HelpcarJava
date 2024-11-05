package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Agenda;
import br.com.fiap.conexoes.ConexaoFactory;

public class AgendaDao {
	
	public Connection minhaConexao;
	
	public AgendaDao() throws ClassNotFoundException, SQLException {
		super();
		this.minhaConexao = new ConexaoFactory().conexao();
	}
	
	// Insert 
	public String inserir (Agenda agenda) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement
				(" Insert into AGENDAMENTO values (?, ?, ?, ?)");
			stmt.setInt(1, agenda.getCodigo());
			stmt.setDate(2, java.sql.Date.valueOf(agenda.getData()));			
			stmt.setTime(2, java.sql.Time.valueOf(agenda.getHora()));			
			stmt.setString(4, agenda.getServico());
			stmt.execute();
			stmt.close();			
		return "Agendamento realizado com Sucesso!";
	}
	
	// Delete
	public String deletar(int codigo) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement
				("Delete from AGENDAMENTO where id_agendamento = ?");
			stmt.setInt(1, codigo);
			stmt.execute();
			stmt.close();		
		return "Agendamento deletado com Sucesso!";
	}

	// Select 
	public List<Agenda> selecionar() throws SQLException{
		List<Agenda> listaAgenda = new ArrayList<Agenda>();
		PreparedStatement stmt = minhaConexao.prepareStatement
				("SELECT * FROM AGENDAMENTO");
		
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Agenda agenda = new Agenda();
				agenda.setCodigo(rs.getInt(1));
				agenda.setData(rs.getDate("data").toLocalDate()); 
                agenda.setHora(rs.getTime("hora").toLocalTime());
				agenda.setServico(rs.getString(4));
				listaAgenda.add(agenda);
			}		
		return listaAgenda;		
	}
	

}
