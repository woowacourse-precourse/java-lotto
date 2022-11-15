package lotto.type;

public enum ErrorType {
    INVALID_PRICE_INPUT("[ERROR] 구입 금액은 1000원 으로 나누어 떨어져야 합니다."),
    INVALID_NUMBER_DIGITS("[ERROR] 쉼표만으로 구분한 6자리 숫자를 입력해야 합니다."),
    INVALID_NUMBER_RANGE("[ERROR] 숫자는 1~45 사이의 숫자여야 합니다."),
    INVALID_DUPLICATED_NUMBER("[ERROR] 번호는 중복이될 수 없습니다"),
    INVALID_INPUT_TYPE("[ERROR] 숫자만 입력하여야 합니다.");

    private final String errorText;

    ErrorType(String errorText) {
        this.errorText = errorText;
    }

    public String getText() {
        return errorText;
    }
}
