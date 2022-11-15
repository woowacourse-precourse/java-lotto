package lotto.utils;

public enum OutputMessage {
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    LOTTO_COUNT("개를 구매했습니다."),
    INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),

    WINNING_STATISTICS_MESSAGE("당첨 통계\n---"),
    WINNING_FIRST("6개 일치 (2,000,000,000원) - "),
    WINNING_SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    WINNING_THIRD("5개 일치 (1,500,000원) - "),
    WINNING_FOURTH("4개 일치 (50,000원) - "),
    WINNING_FIFTH("3개 일치 (5,000원) - "),
    WINNING_ALL_COUNT("개"),
    ALL_RATE_OF_RETURN("총 수익률은 "),
    END_RATE_OF_RETURN("%입니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
