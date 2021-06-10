package ru.vtb.learning.lesson8;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class Repository<T extends User> {
    private EntityManagerFactory factory;
    private Class<T> type;

    public Repository(EntityManagerFactory factory, Class<T> type) {
        this.factory = factory;
        this.type = type;
    }

    public void save(T obj){

        if(obj == null){
            // или кинуть эксепшн, или сделать trySave
            return;
        }

        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(obj);
        transaction.commit();
    }

    public T getById(long id){
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        T res = entityManager.find(type, id);
        transaction.commit();
        return res;
    }
}
