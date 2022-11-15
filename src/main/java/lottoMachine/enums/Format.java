package lottoMachine.enums;

public enum Format {
    NUMBER_FORMAT("^[0-9]+$"),
    WINNING_NUMBER_FORMAT("\\d+,\\d+,\\d+,\\d+,\\d+,\\d+"),
    DECIMAL_FORMAT("%.1f"),
    DECIMAL_PRINT_FORMAT("#,##0.0");

    private final String format;

    Format(String format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return format;
    }
}
