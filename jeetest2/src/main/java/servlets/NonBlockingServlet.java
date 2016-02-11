package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import others.ExampleReadListener;

@WebServlet(asyncSupported = true, urlPatterns = { "nonblocking" })
public class NonBlockingServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		AsyncContext ac = request.startAsync();

		ServletInputStream sis = request.getInputStream();

		sis.setReadListener(new ExampleReadListener(sis, ac));

		PrintWriter writer = response.getWriter();
		writer.println("Non Blocking Servlet completed. Check logs.");
		writer.flush();

	}

}
