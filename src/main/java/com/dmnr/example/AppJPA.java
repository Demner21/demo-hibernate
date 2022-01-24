package com.dmnr.example;

import com.dmnr.example.entity.Guide;
import com.dmnr.example.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class AppJPA {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello-world");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
            List<Student> from_student_ = entityManager.createQuery("from Student ").getResultList();
            for (Student student :
                    from_student_) {
                System.out.println(student);
                if (student.getEnrollmentId().equals("A")){
                    student.setGuide(entityManager.find(Guide.class, 6L));
                }
            }

            List<Guide> guides= entityManager.createQuery("from Guide where id not in (6 , 8 )").getResultList();
            for (Guide guide :
                    guides) {
                entityManager.remove(guide);
            }
            // solo los nombres de los guias:
            List<String> guidesNames= entityManager.createQuery("""
                                                                    select guide.name
                                                                    from Guide  as guide
                                                                    """).getResultList();

            for (String name :
                    guidesNames) {
                System.out.println(name);
            }
            var nameSearching = "Eru";
            List<String> guidesWithNameEru= entityManager.createQuery("""
                                                                    select guide.name
                                                                    from Guide  as guide
                                                                    where guide.name= :name
                                                                    """)
                                                                    .setParameter("name",nameSearching)
                                                                    .getResultList();

            //buscando solo un nombre usando named parameter
            for (String name :
                    guidesWithNameEru) {
                System.out.println(name);
            }


            //var guide2 = entityManager.find(Guide.class,4L);
            //Student student = entityManager.find(Student.class, 5L);
            //student.setName("Flagg Flagg");
            //student.setEnrollmentId("A");
            //student.setGuide(guide2);
            transaction.commit();
        }catch (Exception e){
            if (transaction!=null) transaction.rollback();
        }finally {
            if (entityManager!=null)entityManager.close();
        }
    }
}
