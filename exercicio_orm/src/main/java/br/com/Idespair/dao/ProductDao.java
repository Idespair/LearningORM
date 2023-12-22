package br.com.Idespair.dao;

import br.com.Idespair.domain.Product;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class ProductDao implements IProductDao{
    @Override
    public Product register(Product prod)
    {
        try (EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA")){
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();
            entityManager.persist(prod);
            entityManager.getTransaction().commit();

            entityManager.close();
            entityManagerFactory.close();
        }
        return prod;
    }

    @Override
    public void delete(Product prodDelete) {
        try (EntityManagerFactory entityManagerFactory =
                     Persistence.createEntityManagerFactory("ExemploJPA")) {
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();
            prodDelete = entityManager.merge(prodDelete);
            entityManager.remove(prodDelete);
            entityManager.getTransaction().commit();

            entityManager.close();
            entityManagerFactory.close();
        }
    }

    @Override
    public List<Product> list() {
        try (EntityManagerFactory entityManagerFactory =
                     Persistence.createEntityManagerFactory("ExemploJPA")) {
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Product> query = builder.createQuery(Product.class);
            Root<Product> root = query.from(Product.class);
            query.select(root);

            TypedQuery<Product> tpQuery =
                    entityManager.createQuery(query);
            List<Product> list = tpQuery.getResultList();

            entityManager.close();
            entityManagerFactory.close();
            return list;
        }
    }
}
