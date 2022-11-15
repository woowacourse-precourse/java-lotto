package lotto.enums;

public enum OutputMessage {
    WINNING_STATITSTICS_FIFTH_PRIZE("3개 일치 (5,000원) - "), WINNING_STATITSTICS_FOURTH_PRIZE("4개 일치 (50,000원) - "), WINNING_STATITSTICS_THIRD_PRIZE("5개 일치 (1,500,000원) - "),
    WINNING_STATITSTICS_SECOND_PRIZE("5개 일치, 보너스 볼 일치 (30,000,000원) - "), WINNING_STATITSTICS_FIRST_PRIZE("6개 일치 (2,000,000,000원) - "), EA("개"),
    PROFIT_RATE_PREFIX_MESSAGE("총 수익률은 "), PROFIT_RATE_SUFIX_MESSAGE("%입니다.");

    String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
