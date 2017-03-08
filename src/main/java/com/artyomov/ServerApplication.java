package com.artyomov;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/**
 * Main class to run this application using servlet 3.0 (without web.xml).
 *
 * @author Vlad Artyomov
 * @since 06.03.2017, 10:49
 */
@ApplicationPath("/")
public class ServerApplication extends ResourceConfig {
    public ServerApplication() {
        packages("com.artyomov.resources");
    }
}