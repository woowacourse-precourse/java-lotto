package lotto.message;

public enum Message {
    REQUEST_MONEY("구입금액을 입력해 주세요."),
    HOW_MANY_SOLD("개를 구매했습니다."),
    ENTER_WINNING_NUMBER("\n당첨 번호를 입력해 주세요."),
    ENTER_BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
    PRIZE_RESULT("\n당첨 통계\n---");

    public final String message;

    Message(String message) {
        this.message = message;
    }
}
