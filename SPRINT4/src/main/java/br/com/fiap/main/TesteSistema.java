package br.com.fiap.main;


import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.JOptionPane;

import br.com.fiap.beans.AvaliacaoDoCliente;
import br.com.fiap.beans.CatalogoDePecas;
import br.com.fiap.beans.Cliente;
import br.com.fiap.beans.ComponenteAutomotiva;
import br.com.fiap.beans.Orcamento;
import br.com.fiap.beans.Reparo;
import br.com.fiap.beans.Seguro;
import br.com.fiap.beans.TipoDeServico;


public class TesteSistema {
	private static String texto(String j) {
        return JOptionPane.showInputDialog(j);
    }

    // Método para coletar um número inteiro do usuário
    private static int inteiro(String j) {
        return Integer.parseInt(texto(j));
    }

    // Método para coletar um número decimal do usuário
    private static double decimal(String j) {
        return Double.parseDouble(texto(j));
    
    }

    // Método para coletar uma data do usuário
    private static LocalDate dia(String j) {
        return LocalDate.parse(texto(j));
    }

    private static LocalTime hora(String j) {
        return LocalTime.parse(texto(j));
    }

	public static void main(String[] args) {
		Cliente objCliente = new Cliente(
				texto("Informe seu CPF: "),
				texto("Informe seu nome: "),
				texto("Informe seu e-mail: "),
				texto("Informe seu telefone: "),
				texto("Informe seu endereço: "),
				inteiro("Informe sua idade: "),
				texto("Informe sua senha: "));
						
		// String manutencaoPreventiva, String reparoDeMotor, String trocaDeOleo
		TipoDeServico tipoDeServico = new TipoDeServico(
				texto("Você necessita de uma manutenção preventiva? "),
				texto("Você necessita de um reparo no motor? "),
				texto("Você necessita de uma troca de óleo? "));

		// String seguradora, String numeroDaApolice, String dataDeVencimento
		Seguro objSeguro = new Seguro(
				inteiro("Digite o código: "),
				texto("Digite o número da apólice: "),
				dia("Digite a data de vencimento do seguro: "),
				inteiro("Digite o número da cobertura: "));

		// String nomeDasPecas, String fabricantes, int numeroDePecas, double
		// precos
		CatalogoDePecas objCatalogoDePecas = new CatalogoDePecas(
				texto("Digite o nome das peças: "),
				texto("Digite os fabricantes: "),
				inteiro("Digite o número de peças: "),
				decimal("Digite o preço: "));

		// String motor, String transmissao, String freios, String suspensao
		ComponenteAutomotiva objComponenteAutomotiva = new ComponenteAutomotiva(
				texto("Digite as informações sobre o motor"),
				texto("Digite as informações da transmissão: "),
				texto("Digite as informações do freio: "),
				texto("Digite as informações da suspensão: "));

		// String detalhesDosServicosPropostos, double custoEstimados, double
		// tempoDeConclusao
		Orcamento objOrcamento = new Orcamento(
				texto("Digite os detalhes do serviço "),
				decimal("Custo estimado: "), 
				decimal("Tempo de conclusão: "));
		// String descricaoDoProblema, String pecasNecessarias, String
		// tempoEstimadodeReparo+
		Reparo objReparo = new Reparo(
				texto("Descreva o problema"),
				texto("Digite as peças necessárias: "),
				hora("Tempo de reparo estimado: "));

		// String dataDaAvaliacao, String comentarios, double pontuacaoDaAvaliacao
		AvaliacaoDoCliente objAvaliacaoDoCliente = new AvaliacaoDoCliente(
				texto("Data da avaliação"),
				texto("Comentário"),
				decimal("Digite a avaliação do nosso serviço de 0 a 5: "));

		
		 System.out.println("DADOS DO CLIENTE" + 
				 "\n\nNome: " + objCliente.getNome()+
				 "\nCPF: " + objCliente.getCpf()+
				 "\nE-mail: " + objCliente.getEmail()+
				 "\nEndereço: " + objCliente.getEndereco()+
				 "\nTelefone: " + objCliente.getTelefone()+
				 "\nIdade: " + objCliente.getIdade()+
				 "\nSenha: " + objCliente.getSenha()+
				 "\n\n\nSERVIÇOS"+
				 "\n\nTipo de Serviço:"+
				 "\nManutenção Preventiva: " + tipoDeServico.getManutencaoPreventiva()+
				 "\nReparo de Motor: " + tipoDeServico.getReparoDeMotor()+
				 "\nTroca de Óleo: " + tipoDeServico.getTrocaDeOleo()+
				 "\n\n\nSEGURO"+
				 "\n\nCódigo: " + objSeguro.getCodigo()+
				 "\nNúmero da Apólice: " + objSeguro.getNumeroDaApolice()+
				 "\nData de Vencimento: " + objSeguro.getDataDeVencimento()+
				 "\nCobertura: " + objSeguro.getCobertura()+
				 "\n\n\nCATÁLOGO DE PEÇAS"+
				 "\n\nNome das Peças: " + objCatalogoDePecas.getNomeDasPecas()+
				 "\nFabricantes: " + objCatalogoDePecas.getFabricantes()+
				 "\nNúmero de Peças: " + objCatalogoDePecas.getNumeroDePecas()+
				 "\nPreço: " + objCatalogoDePecas.getPrecos()+
				 "\n\n\nCOMPONENTE AUTOMOTIVO"+
				 "\n\nMotor: " + objComponenteAutomotiva.getMotor()+ 
				 "\nTransmissão: " + objComponenteAutomotiva.getTransmissao()+
				 "\nFreios: " + objComponenteAutomotiva.getFreios()+
				 "\nSuspensão: " + objComponenteAutomotiva.getSuspensao()+
				 "\n\n\nORÇAMENTO"+
				 "\n\nDetalhes dos Serviços Propostos: " + objOrcamento.getDetalhesDosServicosPropostos()+
				 "\nCusto Estimado: " + objOrcamento.getCustosEstimados()+
				 "\nTempo de Conclusão: " + objOrcamento.getTempoDeConclusao()+
				 "\n\n\nREPARO"+
				 "\n\nDescrição do Problema: " + objReparo.getDescricaoDoProblema()+
				 "\nPeças Necessárias: " + objReparo.getPecasNecessarias()+
				 "\nTempo Estimado de Reparo: " + objReparo.getTempoEstimadoDeReparo()+
				 "\n\n\nAVALIAÇÃO DO CLIENTE"+
				 "\n\nData da Avaliação: " + objAvaliacaoDoCliente.getDataDaAvaliacao()+
				 "\nComentários: " + objAvaliacaoDoCliente.getComentarios()+
				 "\nPontuação da Avaliação: " + objAvaliacaoDoCliente.getPontuacaoDaAvaliacao());
	}

}
