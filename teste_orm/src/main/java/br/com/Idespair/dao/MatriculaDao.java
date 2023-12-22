package br.com.Idespair.dao;

import br.com.Idespair.domain.Matricula;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class MatriculaDao implements IMatriculaDao {

    @Override
    public Matricula cadastrar(Matricula mat) {

        try (EntityManagerFactory entityManagerFactory =
                     Persistence.createEntityManagerFactory("ExemploJPA")) {
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();
            entityManager.persist(mat);
            entityManager.getTransaction().commit();

            entityManager.close();
            entityManagerFactory.close();

            return mat;
        }
    }

    @Override
    public void excluir(Matricula matric) {

        try (EntityManagerFactory entityManagerFactory
                     = Persistence.createEntityManagerFactory("ExemploJPA")) {
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();
            matric = entityManager.merge(matric);
            entityManager.remove(matric);
            entityManager.getTransaction().commit();

            entityManager.close();
            entityManagerFactory.close();
        }
    }

    @Override
    public List<Matricula> buscarTodos() {

        try (EntityManagerFactory entityManagerFactory
                     = Persistence.createEntityManagerFactory("ExemploJPA")) {
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Matricula> query = builder.createQuery(Matricula.class);
            Root<Matricula> root = query.from(Matricula.class);
            query.select(root);

            TypedQuery<Matricula> tpQuery =
                    entityManager.createQuery(query);
            List<Matricula> list = tpQuery.getResultList();

            entityManager.close();
            entityManagerFactory.close();
            return list;
        }

    }
}
