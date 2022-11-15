package lotto.view.constant;

public enum ResultPhrase {
    TITLE("당첨 통계"),
    SEPARATE_LINE("---"),
    RANK("%d개 일치 (%s원) - %d개"),
    SECOND_RANK("%d개 일치 (%s원), 보너스 볼 일치 - %d개"),
    PROFIT_RATE("총 수익률은 %s%%입니다.");

    private final String phrase;

    private ResultPhrase (String phrase) {
        this.phrase = phrase;
    }

    public String getPhrase() {
        return phrase;
    }
}
