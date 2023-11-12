package dominio;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Supplier;

public class Chatbot {
	private Map<String, Supplier<String>> respostas;
	private Paciente paciente;
	private Medico medico;
	private Prontuario prontuarioAtual;

	public Chatbot() {
		respostas = new HashMap<>();
		respostas.put("olá", () -> "Olá! Como posso ajudar?");
		respostas.put("como você está", () -> "Eu sou apenas um programa, mas obrigado por perguntar!");
		respostas.put("adeus", () -> "Até mais! Se precisar de alguma coisa, estou aqui.");
		respostas.put("informações paciente", () -> obterInformacoesPaciente());
		respostas.put("informações médico", () -> obterInformacoesMedico());
		respostas.put("ver prontuário", () -> verProntuario());
		respostas.put("marcar consulta", () -> marcarConsulta());
		respostas.put("receber orientação médica", () -> receberOrientacaoMedica());
		respostas.put("pedir exames", () -> pedirExames());
		respostas.put("receber resultados de exames", () -> receberResultadosExames());
		respostas.put("agendar procedimento", () -> agendarProcedimento());
		respostas.put("sair", () -> "Obrigado por usar o chatbot. Até mais!");
		respostas.put("medicamentos prescritos", () -> obterMedicamentosPrescritos());
		respostas.put("informações de procedimento", () -> obterInformacoesProcedimento());
		respostas.put("solicitar renovação de receita", () -> solicitarRenovacaoReceita());
		respostas.put("ver histórico de consultas", () -> verHistoricoConsultas());
	}

	private String marcarConsulta() {
		return "Consulta marcada. Aguarde confirmação.";
	}

	private String receberOrientacaoMedica() {
		return "Por favor, forneça mais detalhes para uma orientação médica adequada.";
	}

	private String pedirExames() {
		return "Exames solicitados. Consulte seu médico para mais detalhes.";
	}

	private String receberResultadosExames() {
		return "Resultados dos exames disponíveis. Consulte seu médico para análise detalhada.";
	}

	private String agendarProcedimento() {

		return "Procedimento agendado. Aguarde confirmação.";
	}

	private String obterMedicamentosPrescritos() {
		return "Medicamentos prescritos: [Lista de medicamentos]";
	}

	private String obterInformacoesProcedimento() {
		return "Informações de procedimento: [Detalhes do procedimento]";
	}

	private String solicitarRenovacaoReceita() {
		return "Solicitação de renovação de receita enviada. Aguarde confirmação.";
	}

	private String verHistoricoConsultas() {
		return "Histórico de consultas: [Detalhes do histórico]";
	}

	private String obterInformacoesPaciente() {
		if (paciente != null) {
			return "Paciente: " + paciente.getNome() + ", CPF e RG: " + paciente.getId();
		} else {
			return "Nenhum paciente selecionado.";
		}
	}

	private String obterInformacoesMedico() {
		if (medico != null) {
			return "Médico: " + medico.getNome() + "CRM e CPF do médico: "+ medico.getId() + ", Especialidade: " + medico.getEspecializacao();
		} else {
			return "Nenhum médico selecionado.";
		}
	}

	private String verProntuario() {
		if (prontuarioAtual != null) {
			String prontuario = "Prontuário:\n" + "Relatório: " + prontuarioAtual.getRelatorio() + "\n" + "Receitas: "
					+ prontuarioAtual.getReceitas() + "\n" + "Exames: " + prontuarioAtual.getExames();
			return prontuario;
		} else {
			return "Nenhum prontuário disponível.";
		}
	}

	public void configurarPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public void configurarMedico(Medico medico) {
		this.medico = medico;
	}

	public void configurarProntuario(Prontuario prontuario) {
		this.prontuarioAtual = prontuario;
	}

	public String obterResposta(String pergunta) {
		Supplier<String> resposta = respostas.getOrDefault(pergunta.toLowerCase(),
				() -> "Desculpe, não entendi a pergunta.");
		return resposta.get();
	}

	public static void main(String[] args) {
		Chatbot chatBot = new Chatbot();
		Scanner scanner = new Scanner(System.in);

		System.out.println(
				"Olá! Eu sou um chatbot simples. Pode começar a fazer perguntas ou digitar 'adeus' para sair.");

		while (true) {
			System.out.print("Usuário: ");
			String pergunta = scanner.nextLine();

			if (pergunta.equalsIgnoreCase("adeus")) {
				System.out.println("Chat encerrado. Até mais!");
				break;
			}

			String resposta = chatBot.obterResposta(pergunta);
			System.out.println("ChatBot: " + resposta);
		}

		scanner.close();
	}
}
