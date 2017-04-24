package com.artyomov.services;

import com.artyomov.persistence.dto.EventInfo;
import com.artyomov.persistence.mapper.EventMapper;
import com.artyomov.persistence.repository.EventRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Vlad Artyomov
 * @since 08.03.2017, 10:00
 */
@Stateless
public class EventService {

    @Inject
    EventRepository eventRepository;

    @Inject
    EventMapper eventMapper;

    public List<EventInfo> addTestEvent() {

        EventInfo eventInfo = new EventInfo();
        eventInfo.setDate(LocalDate.now());
        eventInfo.setDescription("Today is " + eventInfo.getDate().toString());

        eventRepository.save(eventMapper.fromEventInfo(eventInfo));

        return eventRepository.findAll()
                .stream()
                .map(event -> eventMapper.fromEvent(event))
                .collect(Collectors.toList());
    }
}
