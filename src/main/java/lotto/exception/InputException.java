package lotto.exception;

public enum InputException {

    INPUT_NOT_DIGIT("[ERROR] 금액은 0-9까지의 숫자로만 이루어저야 합니다."),
    INPUT_MUST_DIVIDE_BY_LOTTO_UNIT("[ERROR] 금액은 로또 한장의 가격인 1000원 단위로만 입력 가능합니다."),
    INPUT_INVALID_FORM("[ERROR] 당첨 번호는 숫자만 가능하며 쉼표로만 구분되어 있어야 합니다."),
    INPUT_INVALID_DIGIT_RANGE("[ERROR] 당첨 번호는 1 - 45 까지의 숫자만 가능합니다."),
    INPUT_INVALID_DIGIT_COUNT("[ERROR] 당첨 번호는 6개까지만 가능합니다."),
    INPUT_HAS_NOT_DUPLICATE_DIGIT("[ERROR] 당첨 번호는 중복이 존재할 수 없습니다.");

    private final String message;

    InputException(final String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
