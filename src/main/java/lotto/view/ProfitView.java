package lotto.view;

public enum ProfitView {

    PROFIT_RATE("총 수익률은 %.1f%%입니다."),
    ;

    private final String format;

    ProfitView(String format) {
        this.format = format;
    }

    public String render(double data) {
        return String.format(format, data);
    }
}
