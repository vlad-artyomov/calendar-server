package com.artyomov.resources;

import com.artyomov.persistence.dto.EventInfo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.time.LocalDate;

/**
 * Events REST resource.
 *
 * @author Vlad Artyomov
 * @since 08.03.2017, 10:00
 */
@Path("events")
public class EventResource {

    @GET
    @Path("test")
    @Produces("application/json")
    public EventInfo getTestDto() {

        EventInfo eventInfo = new EventInfo();

        eventInfo.setDate(LocalDate.now());
        eventInfo.setDescription("Today is " + eventInfo.getDate().toString());

        return eventInfo;
    }
}
