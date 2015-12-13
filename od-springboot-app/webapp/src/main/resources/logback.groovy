import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.core.ConsoleAppender

import static ch.qos.logback.classic.Level.DEBUG
import static ch.qos.logback.classic.Level.INFO
import static ch.qos.logback.classic.Level.ERROR

appender("STDOUT", ConsoleAppender) {
	encoder(PatternLayoutEncoder) {
		pattern = "%d{HH:mm:ss.SSS} [%thread] %-5level %logger{5} - %msg%n"
	}
}
appender("STDOUT1", ConsoleAppender) {
	encoder(PatternLayoutEncoder) {
		pattern = "-OD- %d{HH:mm:ss.SSS} [%thread] %-5level %logger{5} - %msg%n"
	}
}
appender("STDOUT2", ConsoleAppender) {
	encoder(PatternLayoutEncoder) {
		pattern = "*** %d{HH:mm:ss.SSS} [%thread] %-5level %logger{5} - %msg%n"
	}
}

logger("org.opendolphin", ERROR)
logger("org.opendolphin", INFO, ["STDOUT1"])
logger("org.opendolphin.springboot", INFO, ["STDOUT2"])
logger("com.mycompany", INFO)
root(INFO, ["STDOUT"])
