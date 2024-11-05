package br.com.fiap.beans;

public class ComponenteAutomotiva {

	private String motor;
    private String transmissao;
    private String freios;
    private String suspensao;
    
	@Override
	public String toString() {
		return "ComponenteAutomotiva [motor=" + motor + ", transmissao=" + transmissao + ", freios=" + freios
				+ ", suspensao=" + suspensao + "]";
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public String getTransmissao() {
		return transmissao;
	}

	public void setTransmissao(String transmissao) {
		this.transmissao = transmissao;
	}

	public String getFreios() {
		return freios;
	}

	public void setFreios(String freios) {
		this.freios = freios;
	}

	public String getSuspensao() {
		return suspensao;
	}

	public void setSuspensao(String suspensao) {
		this.suspensao = suspensao;
	}

	public ComponenteAutomotiva() {
		super();
	}

	public ComponenteAutomotiva(String motor, String transmissao, String freios, String suspensao) {
		super();
		this.motor = motor;
		this.transmissao = transmissao;
		this.freios = freios;
		this.suspensao = suspensao;
	}
}
