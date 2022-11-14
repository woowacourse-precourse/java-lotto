package view;

public enum Text {
    REQUEST_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    NOTICE_NUMBER_OF_LOTTO("개를 구매했습니다.");

    private final String outputText;

    Text(String outputText) {
        this.outputText = outputText;
    }

    @Override
    public String toString() {
        return this.outputText;
    }
}
