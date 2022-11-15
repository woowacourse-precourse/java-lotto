package lotto.log;

import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

public class CustomLogger {

    public final static Logger LOG = initLog();

    private CustomLogger() {
    }

    private static Logger initLog() {
        Logger logger = Logger.getGlobal();
        removeDefaultLogHandler(logger);
        addLogHandler(logger);
        return logger;
    }

    private static void removeDefaultLogHandler(Logger logger) {
        logger.setUseParentHandlers(false);
    }

    private static void addLogHandler(Logger logger) {
        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new CustomLogFormatter());
        logger.addHandler(handler);
    }
}
