package com.artyomov.resources;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Test REST resource
 */
@Path("rest")
public class TestResource {

    private static final Logger log = LogManager.getLogger(TestResource.class);

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        log.info("REST call caught!");
        log.error("Test error");
        return "Got it!";
    }
}
