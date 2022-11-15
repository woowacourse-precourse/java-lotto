package lotto.util;

public enum SystemMessage {
    MONEY_INPUT("구입금액을 입력해 주세요."),
    PURCHASES_RESULT("%n%d개를 구매했습니다.%n"),
    WIN_NUMBER_INPUT("%n당첨 번호를 입력해 주세요.%n"),
    BONUS_NUMBER_INPUT("보너스 번호를 입력해 주세요"),
    WIN_STATS("%n당첨 통계%n"),
    HORIZON("---"),
    PROFIT_RATE("총 수익률은 %s%%입니다.%n"),
    _BLANK("");

    private String content;

    SystemMessage(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
