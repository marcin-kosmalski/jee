package servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration;

public class TestServletContextListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("context init!");
		ServletContext sc = sce.getServletContext();
		// Register Servlet
		ServletRegistration sr = sc.addServlet("DynamicServlet",
				"servlets.DynamicServlet");
		sr.setInitParameter("myparam","myvalue");
		sr.addMapping("/dynamic");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Context destroyed!");
		
	}
}
