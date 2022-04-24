package com.dmnr.example;

import com.dmnr.example.entity.Address;
import com.dmnr.example.entity.Event;
import com.dmnr.example.entity.Person;
import com.dmnr.example.manager.EventManager;
import com.dmnr.example.util.HibernateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.IntStream;

public class AppPerson {

  private static final Logger log= LoggerFactory.getLogger(AppPerson.class);

  public static void main(String[] args) {
    log.info("CREANDO PERSON TABLE");

    var session=HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();

    Person persona = new Person();
    persona.setName("Dmnr");
    Address addres = new Address();
    addres.setCity("NK");
    addres.setNameAddress("New Zeland");
    addres.setZipcode("2121");
    persona.setAddres(addres);

    session.persist(persona);

    session.getTransaction().commit();
    session.close();

    log.info("CONSULTANDO PERSON TABLE");
    session=HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    List<Person> listaPersona =session.createQuery("from Person").list();
    for (Person personaItem : listaPersona) {
      log.info("persona encontrada ---< {}", personaItem);
    }
    
    session.getTransaction().commit();
    session.close();

  }

}
