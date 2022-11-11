package lotto.domain;

public enum Error {
    IS_NOT_NUMBER("[ERROR] 입력한 구입 금액이 숫자가 아닙니다."),
    IS_NOT_DIVIDED("[ERROR] 구입 금액이 1000원 단위가 아닙니다.");

    private String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
