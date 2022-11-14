package lotto.constant;

public enum ExceptionConstant {

    PRICE_ERROR("1000원 단위로 입력해야합니다."),
    NUMBER_INPUT_ERROR("숫자 입력만 가능합니다."),
    COUNT_ERROR("6개 숫자 입력만 가능합니다."),
    BONUS_COUNT_ERROR("보너스 볼은 하나만 추첨 가능합니다."),
    INVALID_FORMAT_ERROR("잘못된 형식의 입력입니다.");

    private final String BASE_ERROR_MESSAGE = "[ERROR] ";
    private final String message;
    private final IllegalArgumentException exception;

    ExceptionConstant(String message) {
        this.message = message;
        this.exception = new IllegalArgumentException(BASE_ERROR_MESSAGE + message);
    }

    public IllegalArgumentException getException() {
        return this.exception;
    }
}
