package service.resources;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import entity.Unit;
import service.MyEjb;

@Path("/test")
public class TestResource {

	@Inject
	private MyEjb myEjb;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response get() {
		return Response.ok("Numbers: " + myEjb.generateNumber(4)).build();
	}

	@GET
	@Path("/unit")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get2() {
		return Response.ok(Unit.create("name", "type")).build();
	}

	@GET
	@Path("/unit2")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get3() {
		return Response.ok(myEjb.dotest()).build();
	}
}
