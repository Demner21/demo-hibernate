package com.dmnr.example.manager;

import com.dmnr.example.entity.Event;
import org.hibernate.Session;

public class EventManager {

    private final Session session;

    public EventManager(Session session) {
        this.session = session;
    }

    public void save(Event eventToSave) {
        session.beginTransaction();
        session.save(eventToSave);
        session.getTransaction().commit();
        session.close();
    }

}
