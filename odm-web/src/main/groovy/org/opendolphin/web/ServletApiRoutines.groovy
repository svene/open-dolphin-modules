package org.opendolphin.web

class ServletApiRoutines {

	static String requestBody(def req) {
		req.reader.text
	}
}
