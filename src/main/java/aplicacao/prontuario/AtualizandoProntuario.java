package aplicacao.prontuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Prontuario;

public class AtualizandoProntuario {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("health-sync");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		try {
			Prontuario prontuario1 = em.find(Prontuario.class, 1L);

			System.out.println("Receita atual: " + prontuario1.getReceitas());
			prontuario1.setReceitas("Alprazolam");
			System.out.println("Nova receita: " + prontuario1.getReceitas());

			System.out.println("Relatório atual: " + prontuario1.getRelatorio());
			prontuario1.setRelatorio("Mudança de remédios");
			System.out.println("Novo relatório: " + prontuario1.getRelatorio());

//			System.out.println("Médico atual: " + prontuario1.getMedicoResponsavel());
//			prontuario1.setMedicoResponsavel(null);
//			System.out.println("Novo médico: " + prontuario1.getMedicoResponsavel());
//
//			System.out.println("Exame atual: " + prontuario1.getExames());
//			prontuario1.setExames(null);
//			System.out.println("Novo exame: " + prontuario1.getExames());
//
//			System.out.println("Paciente atual: " + prontuario1.getNomePaciente());
//			prontuario1.setNomePaciente(null);
//			System.out.println("Novo paciente: " + prontuario1.getNomePaciente());

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
