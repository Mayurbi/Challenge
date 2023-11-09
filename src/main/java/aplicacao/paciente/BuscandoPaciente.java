package aplicacao.paciente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Paciente;

import ids.PacienteId;

public class BuscandoPaciente {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("health-sync");
		EntityManager em = emf.createEntityManager();

		try {
			PacienteId codPaciente1 = new PacienteId("23.847.232-2", "927.328.770-00");
			Paciente paciente1 = em.find(Paciente.class, codPaciente1);

			System.out.println("Paciente - ID: " + paciente1.getId().getCpf());

			PacienteId codPaciente2 = new PacienteId("12.543.971-4", "646.116.450-29");
			Paciente paciente2 = em.find(Paciente.class, codPaciente2);

			System.out.println("Paciente - ID: " + paciente2.getId().getCpf() + "  |  "
					+ paciente2.getProntuario().getMedicoResponsavel().getId().getCrm());
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
