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

root(INFO, ["STDOUT"])
logger("org.opendolphin", INFO)
logger("org.opendolphin.springboot", INFO/*, ["STDOUT"]*/)
logger("com.mycompany", INFO)
