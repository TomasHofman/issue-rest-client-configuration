package org.zeiss.quarkus;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RequestScoped
@RegisterRestClient(configKey = "greetings.client")
public interface GreetingsClient {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello();
}
