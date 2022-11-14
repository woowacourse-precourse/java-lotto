package lotto.domain;

import static lotto.constant.Constants.UNIT_OF_LOTTO_PURCHASE;

import java.util.regex.Pattern;
import lotto.constant.ErrorMessage;
import lotto.constant.RegularExpression;

public class Payment {
    private final int money;

    public Payment(String money) {
        validateStringIsNumeric(money);
        int moneyParseInt = Integer.parseInt(money);
        validateZeroInput(moneyParseInt);
        validatePurchaseUnit(moneyParseInt);

        this.money = moneyParseInt;
    }

    public Payment(int money) {
        validateZeroInput(money);
        validatePurchaseUnit(money);

        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    private void validateZeroInput(int money) {
        if (money == 0) {
            throw new IllegalArgumentException(ErrorMessage.USER_INPUT_MONEY_IS_ZERO.getMessage());
        }
    }

    private void validateStringIsNumeric(String money) {
        if (!Pattern.matches(RegularExpression.ONLY_NUMBER.getRegex(), money)) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_IS_ALLOWED_ONLY_NUMERIC.getMessage());
        }
    }

    private void validatePurchaseUnit(int money) {
        if (money % UNIT_OF_LOTTO_PURCHASE != 0) {
            throw new IllegalArgumentException(
                    ErrorMessage.UNIT_OF_LOTTO_PURCHASE_DOES_NOT_COMPLY_WITH_RULE.getMessage()
            );
        }
    }

    public int getNumberOfAvailablePurchases() {
        return money / UNIT_OF_LOTTO_PURCHASE;
    }
}
