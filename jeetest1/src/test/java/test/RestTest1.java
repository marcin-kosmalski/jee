package test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class RestTest1 {

	private static Client client;

	private static String URL = "http://localhost:8080/test1/rest/";

	@BeforeClass
	public static void init() {
		client = ClientBuilder.newClient();
	}

	private String rest(String url) {
		return URL + url;
	}

	@Test
	public void testPeristenceAndTransactionsForEjbSingleton() {

		client.target(rest("singleton/1")).request().get();
		client.target(rest("singleton/1")).request().get();
		client.target(rest("singleton/2")).request().get();

	}

	@Test
	@Ignore
	public void test1() {

		Response res = client.target(rest("test")).request().get();
		System.out.println(res.readEntity(String.class));

	}
}
