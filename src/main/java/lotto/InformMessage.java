package lotto;

public enum InformMessage {
    PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    PURCHASE_COUNT("개를 구매했습니다."),
    WINNING_NUMBER("당첨 번호를 입력해 주세요.");

    private final String MESSAGE;

    InformMessage(final String message) {
        this.MESSAGE = message;
    }
    @Override
    public String toString() {
        return (MESSAGE);
    }
}
