package br.com.Idespair.dao;

import br.com.Idespair.domain.Aluno;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AlunoDao implements IAlunoDao {

    @Override
    public Aluno cadastrar(Aluno aluno) {
        try (EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA")) {
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();
            entityManager.persist(aluno);
            entityManager.getTransaction().commit();

            entityManager.close();
            entityManagerFactory.close();

            return aluno;
        }
    }
}
