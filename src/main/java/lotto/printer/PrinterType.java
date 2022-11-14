package lotto.printer;

public enum PrinterType {

    TEXT_PRINTER {
        @Override
        public Printer getPrinter() {
            return new TextPrinter();
        }
    };

    public abstract Printer getPrinter();

}
