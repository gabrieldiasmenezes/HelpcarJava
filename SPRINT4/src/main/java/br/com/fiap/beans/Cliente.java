package br.com.fiap.beans;

public class Cliente {
	private String cpf;
	private String nome;
	private String email;
	private String telefone;
	private String cep;
	private int idade;
	private String senha;
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return cep;
	}
	public void setEndereco(String endereco) {
		this.cep = endereco;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Cliente() {
		super();
	}
	public Cliente(String cpf, String nome, String email, String telefone, String endereco, int idade, String senha) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.cep = endereco;
		this.idade = idade;
		this.senha = senha;
	}
}