package com.mycompany;


import org.opendolphin.core.server.DTO;
import org.opendolphin.core.server.ServerDolphin;
import org.opendolphin.core.server.Slot;
import org.opendolphin.web.DolphinHandler;

import javax.inject.Inject;

import static com.mycompany.ApplicationConstants.*;

@DolphinHandler
public class InitHandler {

	public static final String COMMAND_INIT = "com.mycompany.InitCommand.CMD_INIT";
	@Inject
	ServerDolphin serverDolphin;

	@DolphinHandler(id = InitHandler.COMMAND_INIT)
	public void handle() {
		// Create PM:
		DTO dto = new DTO( new Slot(ATT_NAME, null), new Slot(ATT_GREETING, null) );
		serverDolphin.presentationModel(PM_APP, null, dto);

		// Init PM:
		serverDolphin.getAt(PM_APP).getAt(ATT_NAME).setValue("Duke");
	}

}
