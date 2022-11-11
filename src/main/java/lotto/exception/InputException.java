package lotto.exception;

public enum InputException {

    INPUT_NOT_DIGIT("[ERROR] 금액은 0-9까지의 숫자로만 이루어저야 합니다."),
    INPUT_MUST_DIVIDE_BY_LOTTO_UNIT("[ERROR] 금액은 로또 한장의 가격인 1000원 단위로만 입력 가능합니다.");

    private final String message;

    InputException(final String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
