package com.qa.rest;

import java.net.URI;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.qa.model.User;
import com.qa.repository.UserRepository;

@Path("/")
public class UserEndPoint {

	@Inject
	private UserRepository userRepository;
 
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/users")
	public Response createUser(User user, @Context UriInfo uriInfo) {
		user = userRepository.createUser(user);
		URI createdURI = uriInfo.getBaseUriBuilder().path("" + user.getId()).build();
		return Response.ok(createdURI.toString()).status(Status.CREATED).build();
	}

	@GET
	@Path("/users/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser(@PathParam("id") int id) {
		if (userRepository.findUser(id).equals(null)) {
			return Response.status(Status.NOT_FOUND).build();
		}
		User user = userRepository.findUser(id);
		return Response.ok(user).build();
	} 

	@DELETE
	@Path("/users/{id}")
	public Response deleteAccount(@PathParam("id") int id) {
		if (userRepository.findUser(id).equals(null)) {
			return Response.status(Status.NOT_FOUND).build();
		}
		userRepository.deleteUser(id);
		return Response.noContent().build();
	}

}
