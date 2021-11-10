# issue-rest-client-configuration Project

since quarkus 2.4.0-final the mutation of the Microprofile Rest Client properties during the runtime does not have effect. 

The issue can be reproduced with the test `GreetingResourceTest.testWithRestClientWithWrongUrl_ViaMP`. With Quarkus 2.3 the runs green.
