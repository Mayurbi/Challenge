package aplicacao.prontuario;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Prontuario;

public class ConsultandoProntuario {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("health-sync");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            List<Prontuario> prontuarios = em.createQuery("select O from Prontuario O", Prontuario.class).getResultList();
            for (Prontuario prontuario : prontuarios) {
                System.out.println(prontuario.getId());
            }

            em.getTransaction().commit();
        } finally {
            em.close();
            emf.close();
        }
    }
}

