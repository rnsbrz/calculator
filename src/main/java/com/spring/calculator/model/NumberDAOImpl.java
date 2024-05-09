package com.spring.calculator.model;

import com.spring.calculator.config.JPAUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public class NumberDAOImpl implements NumberDAO {
    public void insertEntity(Number number) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(number);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Number findEntityByID(int id) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        List list = entityManager.
                createQuery("SELECT n FROM Number n WHERE n.id = :id")
                .setParameter("id", id)
                .getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        return (Number) list.get(0);
    }

    public List<Number> findEntities() {
        EntityManager entityManager =
                JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        List list = entityManager.
                createQuery("SELECT n FROM Number n")
                .getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        return list;
    }

    public void updateEntity(Number number) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Number number2 = entityManager.find(Number.class, number.getId());
        number2.setSk1(number.getSk1());
        number2.setSk2(number.getSk2());
        number2.setRezultatas(number.getRezultatas());
        number2.setZenklas(number.getZenklas());

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void removeEntityByID(int id) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Number number = entityManager.find(Number.class, id);
        entityManager.remove(number);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
