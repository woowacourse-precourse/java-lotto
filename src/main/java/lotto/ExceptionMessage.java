package lotto;

public enum ExceptionMessage {
    PURCHASE_AMOUNT_EXCEPTION("구매 금액은 1000원 이상, 1000원의 배수여야 합니다."),
    WINNING_NUMBER_EXCEPTION("당첨 번호는 [1,45] 범위의 유일한 숫자 6개로 이루어져야 합니다.");

    private final String MESSAGE;
    private final String ERROR = "[ERROR] ";

    ExceptionMessage(final String message) {
        this.MESSAGE = message;
    }
    @Override
    public String toString() {
        return (ERROR + MESSAGE);
    }
}
