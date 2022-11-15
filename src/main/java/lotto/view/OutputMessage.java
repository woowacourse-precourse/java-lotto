package lotto.view;

public enum OutputMessage {
    LOTTO_QUANTITY("개를 구매했습니다."),
    WINNING_STATICS("당첨 통계\n---\n");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
