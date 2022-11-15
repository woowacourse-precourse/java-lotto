package lotto.printer;

public interface Printer {

    void print(PrinterText text);

    void print(PrinterFormat format, Object... params);

    void print(Object data);
}
