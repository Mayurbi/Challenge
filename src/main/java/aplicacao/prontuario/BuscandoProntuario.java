package aplicacao.prontuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Prontuario;

public class BuscandoProntuario {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("health-sync");
		EntityManager em = emf.createEntityManager();

		try {

			Prontuario prontuario1 = em.find(Prontuario.class, 1L);

			System.out.println("Prontuario  - ID: " + prontuario1.getId() + "   |   "
					+ prontuario1.getMedicoResponsavel().getId().getCrm());

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
