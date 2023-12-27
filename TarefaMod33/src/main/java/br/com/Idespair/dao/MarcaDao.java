package br.com.Idespair.dao;

import br.com.Idespair.domain.Marca;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MarcaDao implements IMarcaDao{
    @Override
    public Marca cadastrar(Marca marca) {
        try (EntityManagerFactory entityManagerFactory =
                     Persistence.createEntityManagerFactory("ExemploJPA")) {
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();
            entityManager.persist(marca);
            entityManager.getTransaction().commit();

            entityManager.close();
            entityManagerFactory.close();
        }
        return marca;
    }
}
