package lotto.view.constant;

public enum Format {
    MONEY("###,###"),
    PROFIT_RATE("%.1f");

    private final String format;

    private Format (String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}
