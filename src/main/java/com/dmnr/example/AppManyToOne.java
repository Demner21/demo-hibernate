package com.dmnr.example;

import com.dmnr.example.entity.Guide;
import com.dmnr.example.entity.Student;
import com.dmnr.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AppManyToOne {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Student student= new Student();
        student.setName("Dmnr");
        student.setEnrollmentId("E");
        Guide guide = new Guide();
        guide.setName("Flagg");
        guide.setStaffId("Magic");
        guide.setSalary(21D);
        student.setGuide(guide);
        session.save(student);
        session.save(guide);
        //session.persist(student); // no funciona
        session.getTransaction().commit();
        session.close();
    }
}
