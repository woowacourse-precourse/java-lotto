package lotto;

public enum Error {
    ERROR_INSERT_MONEY_AVAILABLE("[ERROR] 로또 1매 가격은 1000원입니다. 1000원 단위를 맞춰주세요.");

    private String errorMessage;

    Error(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getValue() {
        return this.errorMessage;
    }
}
