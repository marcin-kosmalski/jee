package others;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;

public class ExampleReadListener implements ReadListener {

	private AsyncContext asyncContext;

	private ServletInputStream is;

	public ExampleReadListener(ServletInputStream is, AsyncContext asyncContext) {
		this.asyncContext = asyncContext;
		this.is = is;
	}

	@Override
	public void onDataAvailable() throws IOException {


		try {
			asyncContext.getResponse().getWriter()
					.write("Some data available!\n");
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			//StringBuilder sb = new StringBuilder();
			int len = -1;
			byte b[] = new byte[1024];
			while (is.isReady() && (len = is.read(b)) != -1) {
				String data = new String(b, 0, len);
				asyncContext.getResponse().getWriter().write(data);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

	public void onAllDataRead() {
		try {
			asyncContext.getResponse().getWriter()
					.write("\nAll data has been read!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		asyncContext.complete();
	}

	public void onError(Throwable th) {
		System.out.println(" Error: " + th);
		asyncContext.complete();
	}

}
