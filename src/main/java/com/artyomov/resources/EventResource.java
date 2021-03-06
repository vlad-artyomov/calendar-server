package com.artyomov.resources;

import com.artyomov.persistence.dto.EventInfo;
import com.artyomov.services.EventService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Events REST resource.
 *
 * @author Vlad Artyomov
 * @since 08.03.2017, 10:00
 */
@Path("events")
@Produces("application/json")
public class EventResource {

    @Inject
    EventService eventService;

    @GET
    @Path("test")
    public Response getTestDto() {
        EventInfo eventInfo = new EventInfo();

        eventInfo.setDate(LocalDate.now());
        eventInfo.setDescription("Today is " + eventInfo.getDate().toString());

        return Response.ok(eventInfo).build();
    }

    @GET
    @Path("testList")
    public Response getTestDtoList() {
        EventInfo eventInfo = new EventInfo();
        eventInfo.setDate(LocalDate.now());
        eventInfo.setDescription("Today is " + eventInfo.getDate().toString());

        EventInfo eventInfo1 = new EventInfo();
        eventInfo1.setDate(LocalDate.of(1995, 8, 30));
        eventInfo1.setDescription("My birthday is " + eventInfo1.getDate().toString());

        EventInfo eventInfo2 = new EventInfo();
        eventInfo2.setDate(LocalDate.of(1994, 5, 2));
        eventInfo2.setDescription("My wife birthday is " + eventInfo2.getDate().toString());

        List<EventInfo> events = new ArrayList<>();
        events.add(eventInfo);
        events.add(eventInfo1);
        events.add(eventInfo2);

        GenericEntity<List<EventInfo>> entity = new GenericEntity<List<EventInfo>>(events) {};

        return Response.ok(entity).build();
    }

    @GET
    public Response getEvents() {

        List<EventInfo> events = eventService.addTestEvent();

        GenericEntity<List<EventInfo>> entity = new GenericEntity<List<EventInfo>>(events) {};

        return Response.ok(entity).build();
    }
}
