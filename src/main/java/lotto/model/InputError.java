package lotto.model;

import lotto.Constants;

public enum InputError {
    PREFIX("[ERROR] "),
    NUMBER(PREFIX.message() + "숫자만 입력해야 합니다."),
    MONEY_POSITIVE(PREFIX.message() + "양수를 입력해야 합니다."),
    MONEY_MOD(PREFIX.message() + String.format("%d으로 나누어 떨어지는 숫자를 입력해야 합니다.", Constants.LOTTO_PRICE)),
    LENGTH(PREFIX.message() + String.format("%d 개의 숫자를 %s를 기준으로 구분하여 입력해야 합니다.",
            Constants.NUMBER_LENGTH, Constants.SPLIT_REGEX));
    private final String message;
    InputError(String message) {
        this.message = message;
    }
    public String message() {
        return message;
    }
}
