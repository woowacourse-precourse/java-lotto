package lotto.log;

public class Log {

    private static class LogInstanceHolder {
        private static final Log INSTANCE = new Log();
    }

    public static final Log log = getLogger();


    private static Log getLogger() {
        return LogInstanceHolder.INSTANCE;
    }


    public void error(Throwable e) {
        LogFormatter formatter = new LogFormatter();
        System.out.println(formatter.format(e));
    }

    
}
