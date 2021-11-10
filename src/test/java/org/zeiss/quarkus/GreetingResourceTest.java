package org.zeiss.quarkus;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.zeiss.quarkus.GreetingResource.CONFIG_NAME_SALUTATION;

import io.quarkus.test.junit.QuarkusTest;
import javax.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junitpioneer.jupiter.SetSystemProperty;

@QuarkusTest
public class GreetingResourceTest {

    @Inject
    @RestClient
    GreetingsClient greetingsClient;

    public static final String SALUTATION_1 = "Tag!";
    public static final String SALUTATION_2 = "Servus!";

    @Test
    @SetSystemProperty(key = CONFIG_NAME_SALUTATION, value = SALUTATION_1)
    public void testSalutation1() {
        String message = greetingsClient.hello();
        assertThat(message, containsString(SALUTATION_1));
    }

    @Test
    @SetSystemProperty(key = CONFIG_NAME_SALUTATION, value = SALUTATION_2)
    public void testSalutation2() {
        String message = greetingsClient.hello();
        assertThat(message, containsString(SALUTATION_2));
    }

    @Test
    public void testWithRestClient() {
        assertThat(greetingsClient.hello(), containsString(GreetingResource.GREETING_MESSAGE));
    }

    @Test
    @SetSystemProperty(key = "greetings.client/mp-rest/url", value = "https://www.google.de")
    public void testWithRestClientWithWrongUrl_ViaMP() {
        String message = greetingsClient.hello();
        assertThat(message, not(containsString(GreetingResource.GREETING_MESSAGE)));
    }

    @Disabled("don't work with Quarkus 2.3 and 2.4")
    @Test
    @SetSystemProperty(key = "quarkus.rest-config.\"greetings.client\".url", value = "https://www.google.de")
    public void testWithRestClientWithWrongUrl_QuarkusSpecific() {
        String message = greetingsClient.hello();
        assertThat(message, not(containsString(GreetingResource.GREETING_MESSAGE)));
    }
}