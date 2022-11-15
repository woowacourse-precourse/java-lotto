package lotto.model;

import lotto.Constants;

public enum InputError {
    PREFIX("[ERROR] "),
    NUMBER(PREFIX.message() + "숫자만 입력해야 합니다."),
    MONEY_POSITIVE(PREFIX.message() + "양수를 입력해야 합니다."),
    MONEY_MOD(PREFIX.message() + String.format("%d으로 나누어 떨어지는 숫자를 입력해야 합니다.", Constants.LOTTO_PRICE));
    private final String message;
    InputError(String message) {
        this.message = message;
    }
    public String message() {
        return message;
    }
}
