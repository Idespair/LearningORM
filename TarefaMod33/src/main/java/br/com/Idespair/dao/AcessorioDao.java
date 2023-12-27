package br.com.Idespair.dao;

import br.com.Idespair.domain.Acessorio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AcessorioDao implements IAcessorioDao{

    @Override
    public Acessorio cadastrar(Acessorio acessorio) {
        try (EntityManagerFactory entityManagerFactory =
                     Persistence.createEntityManagerFactory("ExemploJPA")) {
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();
            entityManager.persist(acessorio);
            entityManager.getTransaction().commit();

            entityManager.close();
            entityManagerFactory.close();
        }
        return acessorio;
    }
}
