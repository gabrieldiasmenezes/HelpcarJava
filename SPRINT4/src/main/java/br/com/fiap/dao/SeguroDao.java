package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.fiap.beans.Seguro;
import br.com.fiap.conexoes.ConexaoFactory;

public class SeguroDao {
    private Connection minhaConexao;

    public SeguroDao() throws ClassNotFoundException, SQLException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Método para inserir um seguro
    public String inserir(Seguro seguro) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
            "INSERT INTO SEGURO (codigo, numero_apolice, data_vencimento, cobertura) VALUES (?, ?, ?, ?)");
        stmt.setInt(1, seguro.getCodigo());
        stmt.setString(2, seguro.getNumeroDaApolice());
        stmt.setDate(3, java.sql.Date.valueOf(seguro.getDataDeVencimento()));
        stmt.setInt(4, seguro.getCobertura());
        stmt.execute();
        stmt.close();
        return "Seguro cadastrado com sucesso!";
    }

    // Método para deletar um seguro
    public String deletar(int codigo) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("DELETE FROM SEGURO WHERE codigo = ?");
        stmt.setInt(1, codigo);
        stmt.execute();
        stmt.close();
        return "Seguro deletado com sucesso!";
    }

    // Método para selecionar todos os seguros
    public List<Seguro> selecionar() throws SQLException {
        List<Seguro> listaSeguros = new ArrayList<>();
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM SEGURO");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Seguro seguro = new Seguro();
            seguro.setCodigo(rs.getInt("codigo"));
            seguro.setNumeroDaApolice(rs.getString("numero_apolice"));
            seguro.setDataDeVencimento(rs.getDate("data_vencimento").toLocalDate());
            seguro.setCobertura(rs.getInt("cobertura"));
            listaSeguros.add(seguro);
        }
        rs.close();
        stmt.close();
        return listaSeguros;
    }

    // Método para selecionar seguros por código
    public Seguro selecionarPorCodigo(int codigo) throws SQLException {
        Seguro seguro = null;
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM SEGURO WHERE codigo = ?");
        stmt.setInt(1, codigo);
        ResultSet rs = stmt.executeQuery();
        
        if (rs.next()) {
            seguro = new Seguro();
            seguro.setCodigo(rs.getInt("codigo"));
            seguro.setNumeroDaApolice(rs.getString("numero_apolice"));
            seguro.setDataDeVencimento(rs.getDate("data_vencimento").toLocalDate());
            seguro.setCobertura(rs.getInt("cobertura"));
        }
        
        rs.close();
        stmt.close();
        return seguro;
    }
}
