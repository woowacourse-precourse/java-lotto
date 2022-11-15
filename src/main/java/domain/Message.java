package domain;

public enum Message {
    LOTTO_SIZE_ERROR("[ERROR] 로또 번호는 6개의 숫자여야 합니다."),
    NUMBER_RANGE_ERROR("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATION_ERROR("[ERROR] 중복된 숫자는 입력할 수 없습니다."),
    NUMBER_INPUT_ERROR("[ERROR] 숫자만 입력해주세요."),
    PAYMENT_VALIDATION_ERROR("[ERROR] 1000원 단위로 떨어지는 숫자를 입력해주세요.")
    ;

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
