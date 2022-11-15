package lotto.domain;

public enum Error {
    NUMBER("[ERROR] 숫자가 아닙니다."),
    MONEY("[ERROR] 구입 금액이 1000원 단위가 아닙니다."),
    COUNT("[ERROR] 6개가 아닙니다."),
    RANGE("[ERROR] 당첨번호의 범위를 벗어났습니다."),
    UNIQUE_NUMBER("[ERROR] 유일한 숫자가 아닙니다.");

    private String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
