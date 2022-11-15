package lotto.message;

public enum ErrorMessage {
    INVALID_PURCHASE_PRICE("잘못된 입력 금액입니다."),
    NOT_POSITIVE_INTEGER("금액은 양의 정수여야 합니다."),
    NOT_DIGIT("문자가 아닌 숫자만을 입력해주세요."),
    INVALID_NUMBER_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    OVERLAPPED_NUMBER("중복된 숫자가 존재합니다."),
    INVALID_LOTTO_SIZE("로또 번호는 6개여야 합니다.");

    private static final String MESSAGE_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return MESSAGE_PREFIX + this.message;
    }
}
