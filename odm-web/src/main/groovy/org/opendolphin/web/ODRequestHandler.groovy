package org.opendolphin.web

import groovy.util.logging.Log
import org.opendolphin.core.server.ServerDolphin

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Log
class ODRequestHandler {

	String handleRequest(HttpServletRequest req, HttpServletResponse resp, String requestBody, ServerDolphin dolphin) {

		req.setCharacterEncoding(getCharset())
		def requestJson = requestBody
		log.finest "received json: $requestJson"
		def commands = dolphin.serverConnector.codec.decode(requestJson)
		def results = new LinkedList()
		for (command in commands) { // a subclass could override this for less defensive exception handling
			log.finest "processing $command"
			results.addAll dolphin.serverConnector.receive(command)
		}
		def jsonResponse = dolphin.serverConnector.codec.encode(results)
		log.finest "sending json response: $jsonResponse"
		return jsonResponse
	}

	protected String getCharset() {
		"UTF-8"
	}

}
