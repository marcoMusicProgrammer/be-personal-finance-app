package com.personal.app.models.repositories;

import java.util.List;

import com.personal.app.helper.HibernateHelper;

import jakarta.persistence.EntityManager;

public abstract class GenericRepository <T> implements BaseRepository<T> {
    
    protected EntityManager em = HibernateHelper.getEntityManager();
    protected Class<T> entityClass;

    public GenericRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public void insert(T t) {
        try {
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
        } catch (Exception e) {
            if(em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public List<T> findAll() {
        try {
            return em.createQuery("SELECT u FROM "+ entityClass.getSimpleName()+" u",entityClass)
                .getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving data from DB");
        }
    }

}
