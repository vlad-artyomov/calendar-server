package rest;

import com.artyomov.ServerApplication;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.core.Application;

import static org.junit.Assert.assertEquals;

/**
 * Test just to show how to work with Jersey Test Framework.
 *
 * @author Vlad Artyomov
 * @since 25.03.2017, 13:33
 */
public class MyResourceTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ServerApplication();
    }

    @Test
    public void shouldCheckGetItResponse() {
        //given
        final String expectedResponse = "Got it!";
        //when
        String actualResponse = target("rest").request().get().readEntity(String.class);
        //then
        assertEquals(expectedResponse, actualResponse);
    }
}
