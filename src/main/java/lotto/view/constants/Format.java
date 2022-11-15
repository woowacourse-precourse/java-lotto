package lotto.view.constants;

public enum Format {
    DELIMITER_LOTTO_NUMBERS(","),

    NUMBER_CURRENCY("###,###"),
    NUMBER_CURRENCY_WITH_FIRST_DECIMAL("###,###.#"),

    STRING_ISSUE_AMOUNT("%d개를 구매했습니다."),
    STRING_EARNING_RATIO("총 수익률은 %s%%입니다."),
    STRING_RANK_RESULT("%1$d개 일치 (%2$s원) - %3$d개"),
    STRING_RANK_WITH_BONUS_RESULT("%1$d개 일치, 보너스 볼 일치 (%2$s원) - %3$d개"),
    STRING_ERROR_MESSAGE("[ERROR] %s");

    private final String text;

    Format(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
