package lotto.view;

public enum OutputMessage {

    INPUT_PURCHASE_PRICE_MESSAGE("구입금액을 입력해 주세요."),
    INPUT_ANSWER_NUMBERS_MESSAGE("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS_MESSAGE("당첨 통계\n" + "---"),
    LOTTO_COUNT_MESSAGE("%d개를 구매했습니다.\n"),
    SAME_NUMBER_COUNT_MESSAGE("%d개 일치"),
    BONUS_NUMBER_MESSAGE(", 보너스 볼 일치"),
    WINNER_PRICE_MESSAGE(" (%s원) "),
    TOTAL_COUNT_MESSAGE("- %d개\n"),
    MONEY_DECIMAL_FORMAT("###,###,###,###"),
    EARNING_RATE_MESSAGE("총 수익률은 %.1f%%입니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
