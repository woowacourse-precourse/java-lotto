package lotto.utils;

public enum ErrorMessages {
    PRICE_ERROR("%d의 배수만 입력 가능합니다."),
    ZERO_ERROR("0 보다 큰 숫자를 입력해주세요."),
    RANGE_ERROR("%d과 %d 사이의 정수만 입력 가능합니다."),
    DUPLICATE_ERROR("중복되지 않은 값만 입력 가능합니다."),
    LENGTH_ERROR("%d개의 번호를 입력해주세요."),
    NUMBER_ERROR("숫자만 입력 가능합니다.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}