package others;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletResponse;

public class MyAsyncListener implements AsyncListener {

	@Override
	public void onComplete(AsyncEvent event) throws IOException {
		System.out.println("AppAsyncListener onComplete");
	}

	@Override
	public void onTimeout(AsyncEvent event) throws IOException {
		System.out.println("AppAsyncListener onTimeout");
		ServletResponse response = event.getAsyncContext().getResponse();
		PrintWriter out = response.getWriter();
		out.write("TimeOut Error in Processing");
	}

	@Override
	public void onError(AsyncEvent event) throws IOException {
		System.out.println("AppAsyncListener onError");
	}

	@Override
	public void onStartAsync(AsyncEvent event) throws IOException {
		System.out.println("AppAsyncListener onStartAsync");
	}

}
