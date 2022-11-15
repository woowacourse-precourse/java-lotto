package view;

public enum Text {
    REQUEST_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    NOTICE_NUMBER_OF_LOTTO("개를 구매했습니다."),
    REQUEST_WINNING_NUMBERS("\n당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER("\n보너스 번호를 입력해 주세요.");

    private final String outputText;

    Text(String outputText) {
        this.outputText = outputText;
    }

    @Override
    public String toString() {
        return this.outputText;
    }
}
