package lesson_03.Advance_lesson_03;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class MainLogger {

	private static Logger LOG = Logger.getLogger(MainLogger.class);

	public static void main(String[] args) {
		BasicConfLog();
		DOMConfLog();
		
	}
//Логування на консоль
	public static void BasicConfLog() {
		BasicConfigurator.configure();
		LOG.debug("DEBUG Logger");
		LOG.info("INFO Logger");
		LOG.warn("WARN Logger");
	}
//Логування в файл
	public static void DOMConfLog() {
		DOMConfigurator.configure("loggerConfig.xml");
		LOG.error("ERROR Logger");
	}

}
