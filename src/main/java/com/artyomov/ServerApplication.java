package com.artyomov;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/**
 * @author Vlad Artyomov
 * @since 06.03.2017, 10:49
 */
@ApplicationPath("/")
public class ServerApplication extends ResourceConfig {
    public ServerApplication() {
        packages("com.artyomov.resources");
    }
}
