package com.artyomov.persistence.repository;

import com.artyomov.persistence.jpa.Event;

import javax.inject.Named;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author Vlad Artyomov
 * @since 08.03.2017, 10:00
 */
@Named
public class EventRepository extends AbstractGenericRepository<Event> {

    @Override
    public Event findById(Long id) {
        return findById(id, Event.class);
    }

    @Override
    public List<Event> findAll() {
        TypedQuery<Event> query = entityManager.createNamedQuery(Event.QUERY_ALL, Event.class);
        return query.getResultList();
    }
}
