package lotto.domain;

import lotto.setting.Setting;

public class Money {

    private final long money;

    public Money(String input) throws IllegalArgumentException {
        validateInput(input);
        this.money = Long.parseLong(input);
    }

    // 유효한 입력값인지 검증 기능
    private void validateInput(String input) throws IllegalArgumentException {
        for (int i = 0; i < input.length(); i++) {
            checkDigit(input.charAt(i));
        }
    }

    // 숫자인지 검증 기능
    private void checkDigit(char digit) throws IllegalArgumentException {
        if (!Character.isDigit(digit)) {
            throw new IllegalArgumentException("[ERROR] 금액은 숫자만 입력 가능합니다.");
        }
    }

    // 유효한 숫자인지 검증 기능
    private void validMoney(String input) {
        long number = Long.parseLong(input);
        checkOver1000(number);
        validateNumberUnit(number);
    }

    // 1000이상인지 확인
    private void checkOver1000(long number) {
        if (number < Setting.MIN_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException("[ERROR] 1000 이상의 금액만 가능합니다.");
        }
    }

    // 1000단위 숫자인지 확인
    private void validateNumberUnit(long number) {
        if (number % Setting.PURCHASE_AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 1000 단위의 금액만 가능합니다.");
        }
    }
}
