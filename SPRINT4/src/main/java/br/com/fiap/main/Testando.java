package br.com.fiap.main;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.beans.Cliente;
import br.com.fiap.beans.Seguro;
import br.com.fiap.beans.Veiculo;
import br.com.fiap.dao.ClienteDao;
import br.com.fiap.dao.SeguroDao;
import br.com.fiap.dao.VeiculoDao;



public class Testando {
	static String texto(String j) {
		return JOptionPane.showInputDialog(j);
	}

	static int inteiro(String j) {
		return Integer.parseInt(JOptionPane.showInputDialog(j));
	}

	static double real(String j) {
		return Double.parseDouble(JOptionPane.showInputDialog(j));
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Cliente objCliente = new Cliente();
		ClienteDao dao = new ClienteDao();
		Veiculo objVeiculo = new Veiculo();
		VeiculoDao dao1 = new VeiculoDao();
	    Seguro objSeguro = new Seguro();
		SeguroDao dao2 = new SeguroDao();
		
		objCliente.setCpf(texto("CPF: "));
		objCliente.setNome(texto("Nome Completo: "));
		objCliente.setEmail(texto("E-mail: "));
		objCliente.setEndereco(texto("Endereco: "));
		objCliente.setTelefone(texto("Telefone: "));
		objCliente.setIdade(inteiro("Idade: "));
		objCliente.setSenha(texto("Senha: "));

		
		objVeiculo.setCodigo(inteiro("Código do veículo: "));
		objVeiculo.setMarca(texto("Marca do veículo: "));
		objVeiculo.setModelo(texto("Modelo do veículo: "));
		objVeiculo.setAno(inteiro("Ano do veículo: "));
		objVeiculo.setPlaca(texto("Placa do veículo: "));
		
		objSeguro.setCodigo(inteiro("Código do seguro: "));
		objSeguro.setCodigo(inteiro("Código do seguro: "));
		objSeguro.setCodigo(inteiro("Código do seguro: "));
		objSeguro.setCodigo(inteiro("Código do seguro: "));

		
		System.out.println(dao.inserir(objCliente));
		System.out.println(dao1.inserir(objVeiculo));
		System.out.println(dao2.inserir(objSeguro));

	}
	

}


