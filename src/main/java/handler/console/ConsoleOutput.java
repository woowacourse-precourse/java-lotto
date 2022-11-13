package handler.console;

import handler.OutputHandler;

public class ConsoleOutput implements OutputHandler {

    @Override
    public void printf(String format, Object... args) {
        System.out.printf(format, args);
    }

    @Override
    public void println(String content) {
        System.out.println(content);
    }
}
