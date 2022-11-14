package lotto.domain;

public enum ErrorMessage {
    NUMERIC_ERROR("[ERROR] 숫자만 입력해주세요"),
    PRICE_ERROR("[ERROR] 1,000원 단위로 입력해주세요"),
    SIZE_ERROR("[ERROR] 6개의 숫자를 입력해주세요."),
    DUPLICATE_ERROR("[ERROR] 중복되지 않는 숫자를 입력해주세요."),
    RANGE_ERROR("[ERROR] 1 ~ 45 범위 안에 있는 숫자를 입력해주세요");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
