package lotto.utils.validator;

import lotto.utils.constants.IntegerCommon;
import lotto.utils.constants.ErrorMessage;
import lotto.utils.constants.LottoConstant;

public class UserMoneyValidator {

    public static void validate(String money) throws IllegalArgumentException {
        if (!isValidNumberType(money)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_MONEY.getMessage());
        }
        try {
            long parsedMoney = Long.parseLong(money);
            if (!isValidMoneyUnit(parsedMoney)) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_UNIT.getMessage());
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_RANGE.getMessage());
        }
    }

    private static boolean isValidMoneyUnit(long money) {
        return money % LottoConstant.LOTTO_AMOUNT_UNIT.getNumber() == IntegerCommon.MOD.getNumber();
    }

    private static boolean isValidNumberType(String money) {
        return money.chars().allMatch(Character::isDigit);
    }

}
