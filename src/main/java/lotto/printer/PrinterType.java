package lotto.printer;

public enum PrinterType {

    TEXT_PRINTER {
        @Override
        public Printer getPrinter() {
            return new TextPrinter();
        }
    },

    MODEL_PRINTER {
        @Override
        public Printer getPrinter() {
            return new ModelPrinter();
        }
    };

    public abstract Printer getPrinter();

}
