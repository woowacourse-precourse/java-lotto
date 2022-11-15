package lotto.io;

public enum OutputMessages {
    MONEY_INPUT_REQUEST_MESSAGE("구입금액을 입력해 주세요."),
    WINNING_NUMBERS_INPUT_REQUEST_MESSAGE("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_INPUT_REQUEST_MESSAGE("보너스 번호를 입력해 주세요."),
    LOTTO_PURCHASE_MESSAGE("%d개를 구매했습니다."),
    WINNING_STATISTICS_MESSAGE("당첨 통계"),
    DIVIDING_LINE("---"),
    EARNING_RATE_MESSAGE("총 수익률은 %.1f%%입니다"),
    FIFTH_STATISTICS_MESSAGE("3개 일치 (5,000원) - %d개"),
    FOURTH_STATISTICS_MESSAGE("4개 일치 (50,000원) - %d개"),
    THIRD_STATISTICS_MESSAGE("5개 일치 (1,500,000원) - %d개"),
    SECOND_STATISTICS_MESSAGE("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    FIRST_STATISTICS_MESSAGE("6개 일치 (2,000,000,000원) - %d개");


    private final String message;

    OutputMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
