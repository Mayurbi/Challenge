package aplicacao.medico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Medico;
import enuns.EspecializacaoEnum;
import ids.MedicoId;

public class AtualizandoMedico {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("health-sync");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		try {
			MedicoId codMedico1 = new MedicoId("CRM/SP135193", "510.246.390-02");

			Medico medico1 = em.find(Medico.class, codMedico1);

			System.out.println("Email atual: " + medico1.getEmail());
			medico1.setEmail("saksksjka@gmail.com");
			System.out.println("Novo email: " + medico1.getEmail());
			
			System.out.println("Senha atual: " + medico1.getSenha());
			medico1.setSenha("1234juripinga");
			System.out.println("Nova senha: " + medico1.getSenha());
			
			System.out.println("Especialização atual: " + medico1.getEspecializacao());
			medico1.setEspecializacao(EspecializacaoEnum.CLINICO);
			System.out.println("Nova especialização: " + medico1.getEspecializacao());	

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
