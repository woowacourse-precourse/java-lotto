package lotto.domain;

import lotto.setting.Setting;

public class Money {

    private final long money;

    public Money(String input) throws IllegalArgumentException {
        validateInput(input);
        this.money = Long.parseLong(input);
    }

    private void validateInput(String input) throws IllegalArgumentException {
        for (int i = 0; i < input.length(); i++) {
            checkDigit(input.charAt(i));
        }
    }

    private void checkDigit(char digit) throws IllegalArgumentException {
        if (!Character.isDigit(digit)) {
            throw new IllegalArgumentException("[ERROR] 금액은 숫자만 입력 가능합니다.");
        }
    }
}
