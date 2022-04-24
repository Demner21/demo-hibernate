package com.dmnr.example.manager;

import com.dmnr.example.entity.Event;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({MockitoExtension.class})
class EventManagerTest {

    @Mock Session session;
    @Mock Transaction transaction;

    @Test
    void save() {
        Mockito.when(session.beginTransaction()).thenReturn(transaction);
        Mockito.when(session.getTransaction()).thenReturn(transaction);
        Mockito.doNothing().when(transaction).commit();

        EventManager manager= new EventManager(session);
        manager.save(new Event());
        Mockito.verify(session, Mockito.times(1)).save(Mockito.any(Event.class));
    }

    @Test
    void get() {
        Mockito.when(session.beginTransaction()).thenReturn(transaction);

        EventManager manager= new EventManager(session);
        long id=1L;
        manager.get(id);
        Mockito.verify(session, Mockito.times(1)).get( Mockito.eq(Event.class),Mockito.anyLong());
    }
}