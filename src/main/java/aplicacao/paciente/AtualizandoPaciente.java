package aplicacao.paciente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Paciente;
import ids.PacienteId;

public class AtualizandoPaciente {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("health-sync");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		try {
			PacienteId codPaciente1 = new PacienteId("23.847.232-2", "927.328.770-00");

			Paciente paciente1 = em.find(Paciente.class, codPaciente1);

			System.out.println("Email atual: " + paciente1.getEmail());
			paciente1.setEmail("carlasmendeska@gmail.com");
			System.out.println("Novo email: " + paciente1.getEmail());

			System.out.println("Senha atual: " + paciente1.getSenha());
			paciente1.setSenha("1ngasocoro");
			System.out.println("Nova senha: " + paciente1.getSenha());

		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}

	}

}
