package lotto.domain;

public enum ErrorMessage {
    MONEY_IS_NOT_NUMBER("[ERROR] 구입 금액은 숫자여야 합니다."),
    MONEY_IS_NEGATIVE_NUMBER("[ERROR] 구입 금액은 0보다 커야 합니다."),
    MONEY_IS_NOT_1000_UNIT("[ERROR] 구입 금액은 1000원 단위여야 합니다."),
    MONEY_IS_NOT_ENTERED("[ERROR] 금액을 입력해주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}