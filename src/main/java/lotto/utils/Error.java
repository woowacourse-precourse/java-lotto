package lotto.utils;

public enum Error {
    INVALID_LOTTO_SIZE("로또 번호의 개수가 6개가 아닙니다.");

    private final String errorMessage;

    Error(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
