package org.acme;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.smallrye.mutiny.Uni;
import jakarta.validation.Valid;
import jakarta.ws.rs.POST;

@RegisterRestClient
public interface Client {
  @POST
  Uni<Post> post(@Valid Post request);
}
