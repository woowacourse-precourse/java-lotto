package lotto.utils.message;

public enum StaticMessagesUtil {
    INPUT_BUY_MONEY("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS("\n당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
    WINNING_RESULT("\n당첨 통계\n---");

    private final String message;

    StaticMessagesUtil(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
