package com.dmnr.example;

import java.util.List;
import java.util.stream.IntStream;

import com.dmnr.example.entity.Address;
import com.dmnr.example.entity.Event;
import com.dmnr.example.entity.Person;
import com.dmnr.example.manager.EventManager;
import com.dmnr.example.util.HibernateUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

  private static final Logger log= LoggerFactory.getLogger(App.class);

  public static void main(String[] args) {
    IntStream rangeOfNumbers = IntStream.range(0,20);
    int sum = rangeOfNumbers.sum();
    log.info("valor suma obtenido {}", sum);

    EventManager manager=  new EventManager(HibernateUtil.getSessionFactory().openSession());
    Event eventToSave = new Event("first event with hibernate with annotations");
    manager.save(eventToSave);

    // now lets pull events from the database and list them
	var	session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
    var event1= session.get(Event.class, 1L)  ;
    // if (event1 ==null) {
    //   event1= new Event("creating event if doesnt exist before");
    //   event1.setId(1L);
    //   session.merge(event1);
    // }
    log.info("EVENT 1 -->  {} ", event1);

		List<Event> result = session.createQuery( "from Event" ).list();
		for ( Event event : (List<Event>) result ) {
			log.info("event object: {}", event);
      //validateEvent(event);
      if (event.getId()==3 || event.getId()==4) {
        session.delete(event);
      }
		}
		session.getTransaction().commit();
		session.close();

    log.info("CREANDO PERSON TABLE");

    session=HibernateUtil.getSessionFactory().openSession();
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

  private static void validateEvent(Event event) {
    if (event.getId()==5L){
      event.setTitle("dirty change");
    }
  }

}
