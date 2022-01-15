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
        //session.save(student);
        session.persist(student);
        //session.persist(student); // no funciona debido a que no se ha configurado CASCADE
        //para poder persistir solamente usando el metodo persist y pasar 1 solo objeto, se necesita
        //configurar CASCADE  {TRANSITIVE PERSISTENCE} entre las clasess Student y Guide

        session.getTransaction().commit();
        session.close();
    }
}
