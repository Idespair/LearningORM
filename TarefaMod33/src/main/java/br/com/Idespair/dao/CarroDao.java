package br.com.Idespair.dao;

import br.com.Idespair.domain.Carro;
import br.com.Idespair.domain.Marca;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;

import java.util.List;
import java.util.Objects;

public class CarroDao implements ICarroDao{


    @Override
    public Carro cadastrar(Carro carro) {
        try (EntityManagerFactory entityManagerFactory =
                     Persistence.createEntityManagerFactory("ExemploJPA")) {
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();
            entityManager.persist(carro);
            entityManager.getTransaction().commit();

            entityManager.close();
            entityManagerFactory.close();
        }
        return carro;
    }

    @Override
    public void excluir(Carro carroDelete) {
        try (EntityManagerFactory entityManagerFactory
                = Persistence.createEntityManagerFactory("ExemploJPA")){
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction();
            carroDelete = entityManager.merge(carroDelete);
            entityManager.remove(carroDelete);
            entityManager.getTransaction().commit();

            entityManager.close();
            entityManagerFactory.close();
        }
    }

    @Override
    public List<Carro> listarCarros() {
        try(EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA")) {
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Carro> query = builder.createQuery(Carro.class);
            Root<Carro> root = query.from(Carro.class);
            query.select(root);

            TypedQuery<Carro> tpQuery = entityManager.createQuery(query);
            List<Carro> list = tpQuery.getResultList();

            entityManager.close();
            entityManagerFactory.close();
            return list;
        }
    }

    @Override
    public Carro buscarPorMarca(Marca marca) {
        try (EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA")) {
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Carro> query = builder.createQuery(Carro.class);
            Root<Carro> root = query.from(Carro.class);
            Join<Object, Object> join =root.join("marca", JoinType.INNER);
            query.select(root).where(builder.equal(join,marca));

            TypedQuery<Carro> tpQuery =
                    entityManager.createQuery(query);
            return tpQuery.getSingleResult();
        }
    }
}