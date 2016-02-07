package service.resources;

import java.io.Serializable;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import service.MyEjb;
import service.MySingleton;

@Path("/singleton")
public class SingletonResource implements Serializable {

	@Inject
	private MySingleton mySingleton;

	@Inject
	private MyEjb myEjb;

	@GET
	@Path("/1")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get1() {
		mySingleton.op1();

		return Response.ok().build();
	}

	@GET
	@Path("/2")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get2() {
		mySingleton.list();

		return Response.ok().build();
	}

	@GET
	@Path("/3")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get3() {

		myEjb.testSingleton();

		return Response.ok().build();
	}
}
