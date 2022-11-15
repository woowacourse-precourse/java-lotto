package lotto.validate;

public class ValidateNumber {
    private static final String NOT_NUMERIC_MESSAGE = "[ERROR] 구매 금액은 숫자여야 합니다.";
    private static final String UNDER_1000_MESSAGE = "[ERROR] 구매 금액은 1000원 이상이어야 합니다.";
    private static final String NOT_1000_UNIT_MESSAGE = "[ERROR] 구매 금액은 1000원 단위여야 합니다.";
    private static final Integer STANDARD_MONEY = 1000;

    private void isOverStandardMoney(Integer purchaseMoney) {
        if (purchaseMoney < 1000) {
            throw new IllegalArgumentException(UNDER_1000_MESSAGE);
        }
        return;
    }

    private void isUnitStandardMoney(Integer purchaseMoney) {
        if (purchaseMoney % STANDARD_MONEY != 0) {
            throw new IllegalArgumentException(NOT_1000_UNIT_MESSAGE);
        }
    }

    private void isNumeric(String purchaseMoney) {
        try {
            Double.parseDouble(purchaseMoney);
            return;
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMERIC_MESSAGE);
        }
    }
}
