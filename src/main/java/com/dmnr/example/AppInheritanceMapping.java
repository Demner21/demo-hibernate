package com.dmnr.example;

import com.dmnr.example.entity.inheritance.CreditAccount;
import com.dmnr.example.entity.inheritance.DebitAccount;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AppInheritanceMapping {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello-world");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
            //Cat cat = new Cat("Lucy");

            //Dog dog = new Dog("Oliver");

            //entityManager.persist(cat);
            //entityManager.persist(dog);

            //Query query = entityManager.createQuery("select  animal from Animal animal");
            //Stream resultStream = query.getResultStream();
            //resultStream.forEach(System.out::println);

            entityManager.persist(new DebitAccount(21L, "dmnr" , 22));
            entityManager.persist(new DebitAccount(22L, "flagg" , 20));
            entityManager.persist(new CreditAccount(22.9D, "faraday" , 98.5D));
            entityManager.persist(new CreditAccount(32.9D, "renoir" , 45.5D));

            transaction.commit();
        }catch (Exception e){
            if (transaction!=null) transaction.rollback();
        }finally {
            if (entityManager!=null)entityManager.close();
        }
    }
}
