package handler;

public interface OutputHandler {
    void printf(String format, Object... args);

    void println(String content);
}
