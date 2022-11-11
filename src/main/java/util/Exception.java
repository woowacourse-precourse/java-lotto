package util;

import domain.InputConverter;

import static util.Constant.LOTTO_PRICE;

public class Exception {

    private static final String NOT_NUMERAL_MONEY_ERROR = "[ERROR] 구매 금액은 숫자로 입력해야 합니다.";
    private static final String NOT_VALID_MONEY_ERROR = "[ERROR] 구매 금액은 1000원 단위여야 합니다.";
    private static final String NOT_NUMERAL_NUMBER_ERROR = "[ERROR] 로또 번호는 숫자로만 이루어져야 합니다.";
    private static final String NOT_UNIQUE_NUMBER_ERROR = "[ERROR] 로또 번호는 중복되지 않아야 합니다.";
    private static final String NOT_IN_RANGE_NUMBER_ERROR = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    public static void isValidMoneyInput(String moneyInput) {
        isNumeralMoneyInput(moneyInput);
        isValidMoneyUnit(moneyInput);
    }

    private static void isNumeralMoneyInput(String moneyInput) {
        try {
            InputConverter.getMoney(moneyInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMERAL_MONEY_ERROR);
        }
    }

    private static void isValidMoneyUnit(String moneyInput) {
        int money = InputConverter.getMoney(moneyInput);
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(NOT_VALID_MONEY_ERROR);
        }
    }

}
