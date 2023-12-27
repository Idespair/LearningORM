package br.com.Idespair.dao;

import br.com.Idespair.domain.Curso;
import br.com.Idespair.domain.Matricula;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;

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

    @Override
    public Matricula buscarPorCodigoCursoCriteria(String codigoCurso) {
        try (EntityManagerFactory entityManagerFactory
                = Persistence.createEntityManagerFactory("ExemploJPA")) {
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Matricula> query = builder.createQuery(Matricula.class);
            Root<Matricula> root = query.from(Matricula.class);
            Join<Object, Object> join = root.join("curso", JoinType.INNER);
            query.select(root).where(builder.equal(join.get("codigo"),codigoCurso));

            TypedQuery<Matricula> tpQuery =
                    entityManager.createQuery(query);
            Matricula matricula = tpQuery.getSingleResult();

            entityManager.close();
            entityManagerFactory.close();
            return matricula;
        }
    }

    @Override
    public Matricula buscarPorCursoCriteria(Curso curso) {
        try (EntityManagerFactory entityManagerFactory
                = Persistence.createEntityManagerFactory("ExemploJPA")) {
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Matricula> query = builder.createQuery(Matricula.class);
            Root<Matricula> root = query.from(Matricula.class);
            Join<Object, Object> join = root.join("curso", JoinType.INNER);
            query.select(root).where(builder.equal(join, curso));

            TypedQuery<Matricula> tpQuery
                    = entityManager.createQuery(query);
            return tpQuery.getSingleResult();

        }
    }
}
