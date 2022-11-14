package lotto.infra.log;

import lotto.infra.port.outbound.StandardOutput;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Logger {

    public static final String ERROR_PREFIX = "[ERROR]";

    public void error(
            final String message,
            final Class<? extends RuntimeException> exceptionClass
    ) {
        try {
            Constructor<? extends RuntimeException> constructor =
                    exceptionClass.getDeclaredConstructor(String.class);

            error(message);

            throw constructor.newInstance(message);
        } catch (InvocationTargetException | InstantiationException
                 | IllegalAccessException | NoSuchMethodException e) {
            // ignore
        }
    }

    public void error(final String message) {
        String log = String.format("%s %s", ERROR_PREFIX, message);
        StandardOutput.println(log);
    }
}
