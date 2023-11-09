package aplicacao.medico;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dominio.Medico;

public class ListandoMedico {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("health-sync");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Query query = em.createQuery("SELECT M FROM Medico M", Medico.class);

            List<Medico> medicos = query.getResultList();
            for (Medico medico : medicos) {
                System.out.println("ID: " + medico.getId().getCrm());
                System.out.println("Nome: " + medico.getNome());
                System.out.println("Email: " + medico.getEmail());
                System.out.println("Senha: " + medico.getSenha());
                System.out.println("Telefone: " + medico.getTelefone());
                System.out.println("Data de Nascimento: " + medico.getDataNasc());
                System.out.println("Especialização: " + medico.getEspecializacao());

                if (medico.getProntuario() != null) {
                    System.out.println("Prontuário: " + medico.getProntuario().getId());
                } else {
                    System.out.println("Prontuário não encontrado para o médico.");
                }

                System.out.println();
            }

            em.getTransaction().commit();
        } finally {
            em.close();
            emf.close();
        }
    }
}
