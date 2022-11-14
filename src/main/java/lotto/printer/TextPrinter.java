package lotto.printer;

public class TextPrinter implements Printer {

    @Override
    public void print(PrinterText text) {
        System.out.println(text.getText());
    }

    @Override
    public void print(PrinterFormat format, Object... params) {
        String formedText = String.format(format.getFormat(), params);
        System.out.println(formedText);
    }

    @Override
    public void print(Object data) {

    }
}
