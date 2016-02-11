package servlets;

import java.io.IOException;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import others.AsyncService;
import others.MyAsyncListener;

@WebServlet(urlPatterns = { "/async" }, asyncSupported = true)
public class AsyncServlet extends HttpServlet {

	@Resource
	private ManagedExecutorService mes;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		AsyncContext ac = request.startAsync();

		ac.addListener(new MyAsyncListener());
		ac.setTimeout(10000);
		System.out.println(" Async Supported? "
				+ ac.getRequest().isAsyncSupported());
		mes.execute(new AsyncService(ac));

	}

}
