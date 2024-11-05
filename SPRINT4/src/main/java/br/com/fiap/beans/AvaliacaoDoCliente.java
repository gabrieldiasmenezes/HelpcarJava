package br.com.fiap.beans;

public class AvaliacaoDoCliente {

	private String dataDaAvaliacao;
    private String comentarios;
    private double pontuacaoDaAvaliacao;
    
    
	public AvaliacaoDoCliente() {
		super();
	}
	public AvaliacaoDoCliente(String dataDaAvaliacao, String comentarios, double pontuacaoDaAvaliacao) {
		super();
		this.dataDaAvaliacao = dataDaAvaliacao;
		this.comentarios = comentarios;
		this.pontuacaoDaAvaliacao = pontuacaoDaAvaliacao;
	}
	public String getDataDaAvaliacao() {
		return dataDaAvaliacao;
	}
	public void setDataDaAvaliacao(String dataDaAvaliacao) {
		this.dataDaAvaliacao = dataDaAvaliacao;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	public double getPontuacaoDaAvaliacao() {
		return pontuacaoDaAvaliacao;
	}
	public void setPontuacaoDaAvaliacao(double pontuacaoDaAvaliacao) {
		this.pontuacaoDaAvaliacao = pontuacaoDaAvaliacao;
	}
	@Override
	public String toString() {
		return "AvaliacaoDoCliente [dataDaAvaliacao=" + dataDaAvaliacao + ", comentarios=" + comentarios
				+ ", pontuacaoDaAvaliacao=" + pontuacaoDaAvaliacao + "]";
	}
    
	
}
