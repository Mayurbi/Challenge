package aplicacao.paciente;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dominio.Paciente;

public class ListandoPaciente {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("health-sync");
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();

			Query query = em.createQuery("SELECT P FROM Paciente P", Paciente.class);

			List<Paciente> pacientes = query.getResultList();
			for (Paciente paciente : pacientes) {
				System.out.println("ID: " + paciente.getId().getCpf());
				System.out.println("Nome: " + paciente.getNome());
				System.out.println("Email: " + paciente.getEmail());
				System.out.println("Senha: " + paciente.getSenha());
				System.out.println("Telefone: " + paciente.getTelefone());
				System.out.println("Data de Nascimento: " + paciente.getDataNasc());
				System.out.println("Exame: " + paciente.getExame().getTipoExames());
				System.out.println("Prontuário: " + paciente.getProntuario().getExames().getResultado());
				System.out.println();
			}

			em.getTransaction().commit();
		} finally {
			em.close();
			emf.close();
		}

	}
}
