package lotto.view;

public enum Message {
    PURCHASE_PRICE("구입금액을 입력해 주세요."),
    PURCHASE_COUNT("개를 구매했습니다."),
    WINNING_NUMBER_INPUT("당첨 번호를 입력해주세요."),
    BONUS_NUMBER_INPUT("보너스 번호를 입력해 주세요."),
    WINNING_STATS("당첨 통계\n---");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
