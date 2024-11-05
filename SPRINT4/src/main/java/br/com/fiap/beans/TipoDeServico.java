package br.com.fiap.beans;

public class TipoDeServico {


		private String manutencaoPreventiva;
	    private String reparoDeMotor;
	    private String trocaDeOleo;
	    
		@Override
		public String toString() {
			return "TipoDeServico [manutencaoPreventiva=" + manutencaoPreventiva + ", reparoDeMotor=" + reparoDeMotor
					+ ", trocaDeOleo=" + trocaDeOleo + "]";
		}

		public TipoDeServico() {
			super();
		}

		public TipoDeServico(String manutencaoPreventiva, String reparoDeMotor, String trocaDeOleo) {
			super();
			this.manutencaoPreventiva = manutencaoPreventiva;
			this.reparoDeMotor = reparoDeMotor;
			this.trocaDeOleo = trocaDeOleo;
		}

		public String getManutencaoPreventiva() {
			return manutencaoPreventiva;
		}

		public void setManutencaoPreventiva(String manutencaoPreventiva) {
			this.manutencaoPreventiva = manutencaoPreventiva;
		}

		public String getReparoDeMotor() {
			return reparoDeMotor;
		}

		public void setReparoDeMotor(String reparoDeMotor) {
			this.reparoDeMotor = reparoDeMotor;
		}

		public String getTrocaDeOleo() {
			return trocaDeOleo;
		}

		public void setTrocaDeOleo(String trocaDeOleo) {
			this.trocaDeOleo = trocaDeOleo;
		}
	    
	    
}
