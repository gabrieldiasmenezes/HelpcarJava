package br.com.fiap.beans;

public class CatalogoDePecas {

	 private String nomeDasPecas;
	    private String fabricantes;
	    private int numeroDePecas;
	    private double precos;
	    
		@Override
		public String toString() {
			return "CatalogoDePecas [nomeDasPecas=" + nomeDasPecas + ", fabricantes=" + fabricantes + ", numeroDePecas="
					+ numeroDePecas + ", precos=" + precos + "]";
		}

		public CatalogoDePecas() {
			super();
		}

		public CatalogoDePecas(String nomeDasPecas, String fabricantes, int numeroDePecas, double precos) {
			super();
			this.nomeDasPecas = nomeDasPecas;
			this.fabricantes = fabricantes;
			this.numeroDePecas = numeroDePecas;
			this.precos = precos;
		}

		public String getNomeDasPecas() {
			return nomeDasPecas;
		}

		public void setNomeDasPecas(String nomeDasPecas) {
			this.nomeDasPecas = nomeDasPecas;
		}

		public String getFabricantes() {
			return fabricantes;
		}

		public void setFabricantes(String fabricantes) {
			this.fabricantes = fabricantes;
		}

		public int getNumeroDePecas() {
			return numeroDePecas;
		}

		public void setNumeroDePecas(int numeroDePecas) {
			this.numeroDePecas = numeroDePecas;
		}

		public double getPrecos() {
			return precos;
		}

		public void setPrecos(double precos) {
			this.precos = precos;
		}
}
