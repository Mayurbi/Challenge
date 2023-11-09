package aplicacao.prontuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Prontuario;

public class ExcluindoProntuario {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("health-sync");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		try {
			Prontuario prontuario1 = em.find(Prontuario.class, 1L);
			if (prontuario1 != null) {
				em.remove(prontuario1);
				System.out.println("Prontuário removido com sucesso.");
			} else {
				System.out.println("Prontuário não encontrado.");
			}

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
