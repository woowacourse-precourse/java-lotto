package lotto.exception;

public enum InputException {

    MONEY_NOT_DIGIT("[ERROR] 금액은 0-9까지의 숫자로만 이루어저야 합니다."),
    MONEY_NOT_DIVIDE_BY_LOTTO_UNIT("[ERROR] 금액은 로또 한장의 가격인 1000원 단위로만 입력 가능합니다."),
    LOTTO_INVALID_FORM("[ERROR] 당첨 번호는 숫자만 가능하며 쉼표로만 구분되어 있어야 합니다."),
    LOTTO_INVALID_RANGE("[ERROR] 당첨 번호는 1 - 45 까지의 숫자만 가능합니다."),
    LOTTO_INVALID_COUNT("[ERROR] 당첨 번호는 6개까지만 가능합니다."),
    LOTTO_DUPLICATE_DIGIT("[ERROR] 당첨 번호는 중복이 존재할 수 없습니다."),
    BONUS_LOTTO_INVALID_FORM("[ERROR] 보너스 번호는 1-45의 숫자 1개만 가능합니다."),
    BONUS_DUPLICATE("[ERROR] 보너스 번호는 당첨 번호와 달라야 합니다.)");

    private final String message;

    InputException(final String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
