package aplicacao.paciente;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Paciente;

public class ConsultandoPaciente {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("health-sync");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		List<Paciente> pacientes = em.createQuery("select P from Paciente P", Paciente.class).getResultList();
		for (Paciente paciente : pacientes) {
			System.out.println(paciente.getId().getCpf());

			em.close();
			emf.close();

		}

	}
}
