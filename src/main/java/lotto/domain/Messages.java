package lotto.domain;

public enum Messages {
    INPUT_MONEY_MESSAGE("구입금액을 입력해 주세요.");

    final private String message;

    public String get() {
        return message;
    }

    Messages(String message) {
        this.message = message;
    }
}
