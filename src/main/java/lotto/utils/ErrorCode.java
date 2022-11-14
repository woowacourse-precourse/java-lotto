package lotto.utils;

public enum ErrorCode {
    // 로또 금액 관련 오류
    INVALID_PRICE("[ERROR] 로또는 1,000원 단위로 구매할 수 있습니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}