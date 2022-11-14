package lotto.ui;

public enum Ready {
    INSERT_AMOUNT("구입금액을 입력해 주세요.");

    private final String value;

    Ready(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
