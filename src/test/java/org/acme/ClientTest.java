package org.acme;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
public class ClientTest {
  @Inject
  @RestClient
  Client client;

  @Test
  public void test1() {
    // this works
    Post post = new Post(1, 1, "title", "body");
    client.post(post).await().indefinitely();

  }

  @Test
  public void test2() {
    // this doesn't throw a constraint violation, instead throws 
    // HV000116: getParameterIndex() may only be invoked for nodes of type ElementKind.PARAMETER
    
    Post post = new Post(1, 1, "title", null);
    client.post(post).await().indefinitely();
  }  
}
