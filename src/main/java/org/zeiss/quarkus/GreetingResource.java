package org.zeiss.quarkus;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@RequestScoped
@Path("/hello")
public class GreetingResource {

    public static final String GREETING_MESSAGE = "Hello From GreetingResource";
    public static final String CONFIG_NAME_SALUTATION = "greetings.salutation";

    @ConfigProperty(name = CONFIG_NAME_SALUTATION, defaultValue = "Hoi!!")
    String salutation;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return salutation + " " + GREETING_MESSAGE;
    }
}