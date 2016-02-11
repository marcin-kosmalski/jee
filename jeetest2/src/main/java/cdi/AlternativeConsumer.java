package cdi;

import javax.inject.Inject;

public class AlternativeConsumer {

	@Inject
	private IMyAlternative iMyAlternative;

	public void callMe() {

		iMyAlternative.test();

	}

}
