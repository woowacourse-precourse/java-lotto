package lotto;

public enum GameMessage {
    BUY("구입금액을 입력해 주세요."),
    BUY_RESULT("를 구매했습니다."),
    INPUT_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS("보너스 번호를 입력해 주세요."),
    WINNING_STATS("당첨 통계"),
    THREE_HYPHEN("---"),
    FRONT_YIELD_MESSAGE("총 수익률은 "),
    BACK_YIELD_MESSAGE("%입니다."),
    RESULT_RANK_UNITS("개");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
