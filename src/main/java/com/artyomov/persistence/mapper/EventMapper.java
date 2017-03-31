package com.artyomov.persistence.mapper;

import com.artyomov.persistence.dto.EventInfo;
import com.artyomov.persistence.jpa.Event;

import javax.inject.Named;

/**
 * Mapper to convert {@link Event} to {@link EventInfo} and vice-versa.
 *
 * @author <a href="mailto:artyomov.dev@gmail.com">Vlad Artyomov</a>
 *         Date: 08.03.17
 *         Time: 11:31
 */
@Named
public class EventMapper {

    public Event fromEventInfo(EventInfo eventInfo) {
        return new Event.Builder()
                .withDate(eventInfo.getDate())
                .withDescription(eventInfo.getDescription())
                .build();
    }

    public EventInfo fromEvent(Event event) {
        EventInfo eventInfo = new EventInfo();

        eventInfo.setDate(event.getDate());
        eventInfo.setDescription(event.getDescription());

        return eventInfo;
    }
}
