package view;

public enum Text {
    REQUEST_PURCHASE_AMOUNT("구입금액을 입력해 주세요.");

    private final String outputText;

    Text(String outputText) {
        this.outputText = outputText;
    }

    @Override
    public String toString() {
        return this.outputText;
    }
}
