package lotto.validate;

import lotto.Lotto;

public class ValidateNumber {
    private static final String NOT_NUMERIC_MESSAGE = "[ERROR] 구매 금액은 숫자여야 합니다.";
    private static final String UNDER_1000_MESSAGE = "[ERROR] 구매 금액은 1000원 이상이어야 합니다.";
    private static final String NOT_1000_UNIT_MESSAGE = "[ERROR] 구매 금액은 1000원 단위여야 합니다.";
    private static final String NOT_IN_RANGE_MESSAGE = "[ERROR] 번호는 1 ~ 45 사이에 있어야 합니다.";
    private static final String DUPLICATE_NUMBER_MESSAGE = "[EEROR] 중복된 번호가 있습니다.";
    private static final Integer STANDARD_MONEY = 1000;

    private static final Integer RANGE_START = 1;

    private static final Integer RANGE_END = 45;

    public static Integer validatePurchaseMoney(String purchaseMoney) {
        Integer money = Integer.valueOf(purchaseMoney);
        isOverStandardMoney(money);
        isUnitStandardMoney(money);
        isNumeric(purchaseMoney);

        return money;
    }

    private static void isOverStandardMoney(Integer purchaseMoney) {
        if (purchaseMoney < 1000) {
            throw new IllegalArgumentException(UNDER_1000_MESSAGE);
        }
        return;
    }

    private static void isUnitStandardMoney(Integer purchaseMoney) {
        if (purchaseMoney % STANDARD_MONEY != 0) {
            throw new IllegalArgumentException(NOT_1000_UNIT_MESSAGE);
        }
    }

    private static void isNumeric(String purchaseMoney) {
        try {
            Double.parseDouble(purchaseMoney);
            return;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMERIC_MESSAGE);
        }
    }

    public static void validateBonusNumber(int bonusNumber, Lotto lotto) {
        isInRange(bonusNumber);
        isDuplicate(bonusNumber, lotto);
    }

    private static void isInRange(int bonusNumber) {
        if (RANGE_START <= bonusNumber && RANGE_END >= bonusNumber) {
            return;
        }
        throw new IllegalArgumentException(NOT_IN_RANGE_MESSAGE);
    }

    private static void isDuplicate(int bonusNumber, Lotto lotto) {
        if (lotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_MESSAGE);
        }

    }
}
