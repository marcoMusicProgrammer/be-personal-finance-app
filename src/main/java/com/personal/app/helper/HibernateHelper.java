package com.personal.app.helper;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HibernateHelper {

    private static EntityManager instance;

    public static EntityManager getEntityManager() {
        if(instance == null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
            instance = emf.createEntityManager();
        }
        return instance;
    }
}
