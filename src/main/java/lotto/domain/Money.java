package lotto.domain;

import lotto.setting.Setting;

public class Money {

    private final long money;

    public Money(String input) throws IllegalArgumentException {
        checkBlank(input);
        validateInput(input);
        validMoney(input);
        this.money = Long.parseLong(input);
    }

    // 금액 반환 기능
    public long getMoney() {
        return this.money;
    }

    // 유효한 입력값인지 검증 기능
    private void validateInput(String input) throws IllegalArgumentException {
        for (int digit = 0; digit < input.length(); digit++) {
            checkDigit(input.charAt(digit));
        }
    }

    // 빈칸 입력 검증 기능
    private void checkBlank(String input) throws IllegalArgumentException {
        if (input.equals("")) {
            throw new IllegalArgumentException("[ERROR] 공백을 입력할 수 없습니다.");
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
