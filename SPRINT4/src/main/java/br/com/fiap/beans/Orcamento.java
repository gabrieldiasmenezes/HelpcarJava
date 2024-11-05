package br.com.fiap.beans;

public class Orcamento {

	 private String detalhesDosServicosPropostos;
	    private double custosEstimados;
	    private double tempoDeConclusao;
	    
		public Orcamento() {
			super();
		}

		public Orcamento(String detalhesDosServicosPropostos, double custosEstimados, double tempoDeConclusao) {
			super();
			this.detalhesDosServicosPropostos = detalhesDosServicosPropostos;
			this.custosEstimados = custosEstimados;
			this.tempoDeConclusao = tempoDeConclusao;
		}

		public String getDetalhesDosServicosPropostos() {
			return detalhesDosServicosPropostos;
		}

		public void setDetalhesDosServicosPropostos(String detalhesDosServicosPropostos) {
			this.detalhesDosServicosPropostos = detalhesDosServicosPropostos;
		}

		public double getCustosEstimados() {
			return custosEstimados;
		}

		public void setCustosEstimados(double custosEstimados) {
			this.custosEstimados = custosEstimados;
		}

		public double getTempoDeConclusao() {
			return tempoDeConclusao;
		}

		public void setTempoDeConclusao(double tempoDeConclusao) {
			this.tempoDeConclusao = tempoDeConclusao;
		}

		@Override
		public String toString() {
			return "Orcamento [detalhesDosServicosPropostos=" + detalhesDosServicosPropostos + ", custosEstimados="
					+ custosEstimados + ", tempoDeConclusao=" + tempoDeConclusao + "]";
		}
		
		
		
}
