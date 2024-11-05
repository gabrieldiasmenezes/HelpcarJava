package br.com.fiap.beans;

import java.time.LocalDate;
import java.time.LocalTime;

public class Agenda {
	private int codigo;
	private LocalDate data;
	private LocalTime hora;
	private String servico;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public LocalTime getHora() {
		return hora;
	}
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	public String getServico() {
		return servico;
	}
	public void setServico(String servico) {
		this.servico = servico;
	}
	public Agenda(int codigo, LocalDate data, LocalTime hora, String servico) {
		super();
		this.codigo = codigo;
		this.data = data;
		this.hora = hora;
		this.servico = servico;
	}
	public Agenda() {
		super();
	}
	

}
