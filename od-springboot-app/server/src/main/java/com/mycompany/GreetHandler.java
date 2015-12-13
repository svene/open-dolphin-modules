package com.mycompany;


import org.opendolphin.core.server.ServerAttribute;
import org.opendolphin.core.server.ServerDolphin;
import org.opendolphin.web.DolphinHandler;

import javax.inject.Inject;

import static com.mycompany.ApplicationConstants.*;

@DolphinHandler
public class GreetHandler {

	public static final String COMMAND_GREET = "com.mycompany.GreetCommand.CMD_GREET";
	@Inject
	ServerDolphin serverDolphin;

	@DolphinHandler(id = COMMAND_GREET)
	public void handle() {
		String name = (String) serverDolphin.getAt(PM_APP).getAt(ATT_NAME).getValue();
		ServerAttribute greeting = serverDolphin.getAt(PM_APP).getAt(ATT_GREETING);


		// Use 'tryboom' as name to throw exception outside of try/catch:
		if (! name.startsWith("try")) {
			checkName(name);
		}

		// Use 'boom' as name to throw exception inside of try/catch:
		try {
			checkName(name);
			greeting.setValue("Hallo " + name + " !");
		} catch (Exception e) {
			greeting.setValue("Exception caught: " + e.getMessage());
		}
	}

	private void checkName(String name) {
		if (name.contains("boom")) {
			throw new RuntimeException("boom");
		}
	}

}
