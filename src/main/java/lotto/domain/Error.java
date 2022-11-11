package lotto.domain;

public enum Error {
    NOT_NUMBER_ERROR("구매 금액은 숫자여야 합니다.");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "[ERROR] " + message;
    }
}
