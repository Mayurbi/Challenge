package aplicacao;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Exame;
import dominio.Medico;
import dominio.Paciente;
import dominio.Prontuario;
import enuns.EspecializacaoEnum;
import enuns.ExamesEnum;
import ids.MedicoId;
import ids.PacienteId;

public class Programa {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("health-sync");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Paciente paciente1 = new Paciente();
		paciente1.setId(new PacienteId("23.847.232-2", "927.328.770-00"));
		paciente1.setNome("Asdrid Almeida");
		paciente1.setEmail("dede6692@uorak.com");
		paciente1.setSenha("}0578471");
		paciente1.setTelefone("(67) 2116-4848");
		paciente1.setDataNasc(LocalDate.of(1980, 2, 7));
		paciente1.setExame(new Exame(ExamesEnum.HEMOGRAMA, LocalDate.of(2023, 9, 8), "Anemia"));

		if (paciente1.getId() == null)
			em.persist(paciente1);
		else
			em.merge(paciente1);	

		Medico medico1 = new Medico();
		medico1.setId(new MedicoId("CRM/SP135193", "510.246.390-02"));
		medico1.setNome("Pedro Mendes");
		medico1.setEmail("m2ndes1169@hotmail.com");
		medico1.setSenha("Y>zw$GkH");
		medico1.setTelefone("(68) 3951-5180");
		medico1.setDataNasc(LocalDate.of(1969, 1, 1));
		medico1.setEspecializacao(EspecializacaoEnum.PSIQUIATRA);
		
		
		if (medico1.getId() == null)
			em.persist(medico1);
		else
			em.merge(medico1);
		
		Prontuario prontuario1 = new Prontuario();
		prontuario1.setId(1L);
		prontuario1.setNomePaciente(paciente1);
		prontuario1.setExames(new Exame(ExamesEnum.HEMOGRAMA, LocalDate.of(2023, 9, 8), "Lele da cuca"));
		prontuario1.setReceitas("Rivotril");
		prontuario1.setRelatorio("O paciente aprensenta sérios problemas mentais, risco a internação");
		prontuario1.setMedicoResponsavel(medico1);
		medico1.setProntuario(prontuario1);
		
		if (prontuario1.getId() == null)
			em.persist(prontuario1);
		else
			em.merge(prontuario1);
		
		Paciente paciente2 = new Paciente();
		paciente2.setId(new PacienteId("12.543.971-4", "646.116.450-29"));
		paciente2.setNome("Raphael Costa");
		paciente2.setEmail("raphael9935@uorak.com");
		paciente2.setSenha("JCgH5{Z[");
		paciente2.setTelefone("(77) 3276-2155");
		paciente2.setDataNasc(LocalDate.of(1970, 10, 23));
		paciente2.setExame(new Exame(ExamesEnum.URINA, LocalDate.of(2023, 7, 2), "Em análise"));

		if (paciente2.getId() == null)
			em.persist(paciente2);
		else
			em.merge(paciente2);

		Medico medico2 = new Medico();
		medico2.setId(new MedicoId("CRM/SP546133", "520.846.530-07"));
		medico2.setNome("Augusto Flores");
		medico2.setEmail("AugusteFlor@gmail.com");
		medico2.setSenha("Y>zw$GkH");
		medico2.setTelefone("(11) 5678-4590");
		medico2.setDataNasc(LocalDate.of(1960, 6, 6));
		medico2.setEspecializacao(EspecializacaoEnum.DERMATOLOGISTA);

		if (medico2.getId() == null)
			em.persist(medico2);
		else
			em.merge(medico2);

	
		Prontuario prontuario2 = new Prontuario();
		prontuario2.setId(2L);
		prontuario2.setNomePaciente(paciente2);
		prontuario2.setExames(new Exame(ExamesEnum.URINA, LocalDate.of(2023, 7, 10), "Acne Aguda"));
		prontuario2.setReceitas("Acnazil, Tretonoina");
		prontuario2.setRelatorio("Devido a uma infância cheia de chocolate o paciente tem problemas com acne aguda");
		prontuario2.setMedicoResponsavel(medico2);
		medico2.setProntuario(prontuario2);


		if (prontuario2.getId() == null)
			em.persist(prontuario2);
		else
			em.merge(prontuario2);

		em.getTransaction().commit();
		em.close();
		emf.close();

	}
}
