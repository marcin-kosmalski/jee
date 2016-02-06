package service.resources;

import java.io.Serializable;
import java.time.Instant;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/testasync")
@Produces(MediaType.APPLICATION_JSON)
public class MyAsyncResource implements Serializable {

	@GET
	public void asyncGet(@Suspended final AsyncResponse asyncResponse) {

		new Thread(new Runnable() {

			@Override
			public void run() {
	
				asyncResponse.resume(String.valueOf(Instant.now()
						.toEpochMilli()));
			}

		}).start();

	}
}
