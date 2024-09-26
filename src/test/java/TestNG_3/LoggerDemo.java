package TestNG_3;

import org.apache.logging.log4j.*;

public class LoggerDemo {

	public static void main(String[] args) {

		Logger log = LogManager.getLogger("LoggerDemo");
		System.out.println("This is Logger Demo...");

		log.info("For Info Only...");
		log.fatal("For Fatal Message...");
		log.debug("For Debug message...");
		log.error("For Error messgage....");
		log.warn("For Warning message...");
	}
}
