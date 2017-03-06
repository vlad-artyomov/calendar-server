package com.artyomov;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

//TODO refactor this javadoc

/**
 * Created by Vlad on 06.03.2017.
 */
@ApplicationPath("/*")
public class ServerApplication extends ResourceConfig {
    public ServerApplication() {
        packages("com.artyomov.resources");
    }
}
