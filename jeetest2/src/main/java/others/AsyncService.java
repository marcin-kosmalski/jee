package others;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;

public class AsyncService implements Runnable {

	private AsyncContext asyncContext;

	public AsyncService(AsyncContext asyncContext) {
		this.asyncContext = asyncContext;
	}

	@Override
	public void run() {

		System.out.println("thread start: " + Thread.currentThread().getName());


		try {
			PrintWriter out = asyncContext.getResponse().getWriter();
			out.write("AsyncService started!");
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			out.write("AsyncService completed processing!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		asyncContext.complete();

		System.out.println("thread end: " + Thread.currentThread().getName());
	}

}
