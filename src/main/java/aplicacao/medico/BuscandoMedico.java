package aplicacao.medico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Medico;
import ids.MedicoId;

public class BuscandoMedico {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("health-sync");
		EntityManager em = emf.createEntityManager();

		try {

			MedicoId codMedico1 = new MedicoId("CRM/SP135193", "510.246.390-02");
			Medico medico1 = em.find(Medico.class, codMedico1);

			System.out
					.println("Médico  - ID: " + medico1.getId().getCrm());

			MedicoId codMedico2 = new MedicoId("CRM/SP546133", "520.846.530-07");
			Medico medico2 = em.find(Medico.class, codMedico2);

			System.out
					.println("Médico  - ID: " + medico2.getId().getCrm());

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
