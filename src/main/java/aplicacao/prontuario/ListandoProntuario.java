package aplicacao.prontuario;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dominio.Prontuario;

public class ListandoProntuario {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("health-sync");
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();

			Query query = em.createQuery("SELECT O FROM Prontuario O", Prontuario.class);

			List<Prontuario> prontuarios = query.getResultList();
			for (Prontuario prontuario : prontuarios) {
				System.out.println("ID: " + prontuario.getId());
				System.out.println("Receita: " + prontuario.getReceitas());
				System.out.println("Relatório : " + prontuario.getRelatorio());
				System.out.println("Resultado do exame: " + prontuario.getExames().getResultado());
				System.out.println("Médico responsável: " + prontuario.getMedicoResponsavel().getId().getCrm());
				System.out.println("Nome do paciente: " + prontuario.getNomePaciente().getId().getCpf());
				System.out.println(); 
			}

			em.getTransaction().commit();
		} finally {
			em.close();
			emf.close();
		}

	}

}
