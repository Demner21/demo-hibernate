package com.dmnr.example;

import com.dmnr.example.entity.Guide;
import com.dmnr.example.entity.Student;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import java.util.List;

public class AppCriteriaApiJPA {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello-world");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
            List<Student> from_student_ = entityManager.createQuery("from Student ", Student.class)
                                                        .getResultList();
            for (Student student :
                    from_student_) {
                System.out.println(student);
            }

            //haciendo select usando Querying entities
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Guide> criteriaQuery = criteriaBuilder.createQuery(Guide.class);
            Root<Guide> root = criteriaQuery.from(Guide.class);
            criteriaQuery.select(root);
            TypedQuery<Guide> query = entityManager.createQuery(criteriaQuery);
            List<Guide> guides= query.getResultList();
            for (Guide guide :
                    guides) {
                System.out.println(guide);
            }

            CriteriaQuery<String> criteria = criteriaBuilder.createQuery(String.class);
            Root<Guide> root2 = criteria.from(Guide.class);
            Path<String> namePath = root2.get("name");
            criteria.select(namePath);
            List<String> names = entityManager.createQuery(criteria).getResultList();
            for (String nameGuide :
                    names) {
                System.out.println(nameGuide);
            }

            transaction.commit();
        }catch (Exception e){
            if (transaction!=null) transaction.rollback();
        }finally {
            if (entityManager!=null)entityManager.close();
        }
    }
}
