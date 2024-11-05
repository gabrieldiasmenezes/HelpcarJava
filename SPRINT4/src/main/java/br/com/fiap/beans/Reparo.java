package br.com.fiap.beans;

import java.time.LocalTime;

public class Reparo {

	private String descricaoDoProblema;
    private String pecasNecessarias;
    private LocalTime tempoEstimadoDeReparo;
    
	public Reparo(String descricaoDoProblema, String pecasNecessarias, LocalTime tempoEstimadoDeReparo) {
		super();
		this.descricaoDoProblema = descricaoDoProblema;
		this.pecasNecessarias = pecasNecessarias;
		this.tempoEstimadoDeReparo = tempoEstimadoDeReparo;
	}

	public Reparo() {
		super();
	}

	public String getDescricaoDoProblema() {
		return descricaoDoProblema;
	}

	public void setDescricaoDoProblema(String descricaoDoProblema) {
		this.descricaoDoProblema = descricaoDoProblema;
	}

	public String getPecasNecessarias() {
		return pecasNecessarias;
	}

	public void setPecasNecessarias(String pecasNecessarias) {
		this.pecasNecessarias = pecasNecessarias;
	}

	public LocalTime getTempoEstimadoDeReparo() {
		return tempoEstimadoDeReparo;
	}

	public void setTempoEstimadoDeReparo(LocalTime tempoEstimadoDeReparo) {
		this.tempoEstimadoDeReparo = tempoEstimadoDeReparo;
	}

	@Override
	public String toString() {
		return "Reparo [descricaoDoProblema=" + descricaoDoProblema + ", pecasNecessarias=" + pecasNecessarias
				+ ", tempoEstimadoDeReparo=" + tempoEstimadoDeReparo + "]";
	}
	
    
    
}
