package lotto;

public enum Error {
    ERROR_MESSAGE("[ERROR]"),
    WRONG_MONEY(ERROR_MESSAGE.message +"로또 구입 금액은 1000원 단위여야 합니다.");

    private String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
