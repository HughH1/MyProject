package com.qa.rest;

import java.net.URI;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

import com.qa.model.Trick;
import com.qa.repository.TrickRepository;

@Path("/")
public class TrickEndPoint {

	@Inject
	private TrickRepository trickRepository;

	@POST
	@Consumes("application/json")
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/createTrick")
	public Response createTrick(Trick trick, @Context UriInfo uriInfo) {
		trick = trickRepository.createTrick(trick);
		URI createdURI = uriInfo.getBaseUriBuilder().path("" + trick.getId()).build();
		return Response.ok(createdURI.toString()).status(Status.CREATED).build();
	}

	@GET
	@Path("/viewTrick/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTrick(@PathParam("id") int id) {
		Trick trick = trickRepository.findTrick(id);
		if (trick == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(trick).build();
	}
	
	@PUT
	@Consumes("application/json")
	@Path("/updateTrick/{id}")
	public Response updateTrick(Trick trick, @PathParam("id") int id) {
		if (trickRepository.findTrick(id).equals(null)) {
			return Response.status(Status.NOT_FOUND).build();
		}
		trickRepository.updateTrick(id, trick);
		return Response.ok().build();

	}

	@DELETE
	@Path("/delete/{id}")
	public Response deleteTrick(@PathParam("id") int id) {
		if (trickRepository.findTrick(id).equals(null)) {
			return Response.status(Status.NOT_FOUND).build();
		}
		trickRepository.deleteTrick(id);
		return Response.noContent().build();
	}

}
