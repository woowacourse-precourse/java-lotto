package lotto.exception;

public enum ErrorMessage {
    NOT_DIGIT("[ERROR] 구매 금액과 로또 번호는 숫자만 입력이 가능합니다."),
    NOT_THOUSAND_MONEY("[ERROR] 구매 금액은 1,000원 단위로 입력이 가능합니다."),
    INVALID_NUMBERS_INPUT("[ERROR] 당첨 번호를 잘못 입력하셨습니다."),
    DUPLICATE_NUMBER("[ERROR] 로또 번호에 중복된 숫자가 있습니다."),
    NOT_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
