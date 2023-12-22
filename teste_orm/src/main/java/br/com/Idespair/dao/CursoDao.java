package br.com.Idespair.dao;

import br.com.Idespair.domain.Curso;
import br.com.Idespair.domain.Matricula;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class CursoDao implements ICursoDao{


    @Override
    public Curso cadastrar(Curso curso) {

        try (EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA")) {
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();
            entityManager.persist(curso);
            entityManager.getTransaction().commit();

            entityManager.close();
            entityManagerFactory.close();
        }

        return curso;
    }

    @Override
    public void excluir(Curso cur) {
        try (EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA")) {
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();
            cur = entityManager.merge(cur);
            entityManager.remove(cur);
            entityManager.getTransaction().commit();

            entityManager.close();
            entityManagerFactory.close();
        }
    }

    @Override
    public List<Curso> buscarTodos() {

        try (EntityManagerFactory entityManagerFactory
                     = Persistence.createEntityManagerFactory("ExemploJPA")) {
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Curso> query = builder.createQuery(Curso.class);
            Root<Curso> root = query.from(Curso.class);
            query.select(root);

            TypedQuery<Curso> tpQuery =
                    entityManager.createQuery(query);
            List<Curso> list = tpQuery.getResultList();

            entityManager.close();
            entityManagerFactory.close();
            return list;
        }
    }
}
