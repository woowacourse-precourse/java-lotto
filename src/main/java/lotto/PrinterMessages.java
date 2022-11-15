package lotto;

public enum PrinterMessages {
    MONEY_INPUT_REQUEST_MESSAGE("구입금액을 입력해 주세요."),
    WINNING_NUMBERS_INPUT_REQUEST_MESSAGE("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_INPUT_REQUEST_MESSAGE("보너스 번호를 입력해 주세요."),
    LOTTO_PURCHASE_MESSAGE("%d개를 구매했습니다."),
    WINNING_STATISTICS_MESSAGE("당첨 통계"),
    DIVIDING_LINE("---"),
    EARNING_RATE_MESSAGE("총 수익률은 %.1f%%입니다");

    private final String message;

    PrinterMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
