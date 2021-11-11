package org.zeiss.quarkus;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RequestScoped
@Path("/client")
public class ClientResource {

    @RestClient
    GreetingsClient client;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Client returned: " + client.hello();
    }
}