package br.com.fiap.beans;

import java.time.LocalDate;

public class Seguro {

	private int codigo;
    private String numeroDaApolice;
    private LocalDate dataDeVencimento;
    private int cobertura;
	public Seguro() {
		super();
	}
	public Seguro(int codigo, String numeroDaApolice, LocalDate dataDeVencimento, int cobertura) {
		super();
		this.codigo = codigo;
		this.numeroDaApolice = numeroDaApolice;
		this.dataDeVencimento = dataDeVencimento;
		this.cobertura = cobertura;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNumeroDaApolice() {
		return numeroDaApolice;
	}
	public void setNumeroDaApolice(String numeroDaApolice) {
		this.numeroDaApolice = numeroDaApolice;
	}
	public LocalDate getDataDeVencimento() {
		return dataDeVencimento;
	}
	public void setDataDeVencimento(LocalDate dataDeVencimento) {
		this.dataDeVencimento = dataDeVencimento;
	}
	public int getCobertura() {
		return cobertura;
	}
	public void setCobertura(int cobertura) {
		this.cobertura = cobertura;
	}
	@Override
	public String toString() {
		return "Seguro [codigo=" + codigo + ", numeroDaApolice=" + numeroDaApolice + ", dataDeVencimento="
				+ dataDeVencimento + ", cobertura=" + cobertura + "]";
	}

}
