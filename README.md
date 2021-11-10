# issue-rest-client-configuration Project
The repo is created as show case for the quarkus issue: https://github.com/quarkusio/quarkus/issues/21341

# summary
since quarkus 2.4.0-final the mutation of the Microprofile Rest Client properties during the runtime does not have effect. 

The issue can be reproduced with the test `GreetingResourceTest.testWithRestClientWithWrongUrl_ViaMP`. With Quarkus 2.3 the runs green.
