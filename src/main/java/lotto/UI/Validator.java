package lotto.UI;

import java.util.regex.Pattern;

public class Validator {

    private static final String ERROR_MONEY_NOT_NUMBER= "[ERROR] 로또 구입 금액은 숫자로만 입력 가능합니다.";
    private static final String ERROR_MONEY_NOT_OVER_THOUSAND= "[ERROR] 로또 구입 금액은 1000원 이상이어야합니다. ";
    private static final String ERROR_MONEY_NOT_DIVIDED_WITH_THOUSAND= "[ERROR] 로또 구입 금액은 1000으로 나누어 떨어져야합니다. ";


    public void isValidatedMoney(String money) {
        // 숫자만으로 이루어졌는지 검증
        if (!Pattern.matches("[0-9]*]", money)) {
            throw new IllegalArgumentException(ERROR_MONEY_NOT_NUMBER);
        }
        // 1000원 이상이 아니며,, 1000으로 나누어 떨어지지 않는 경우 검증
        int moneyInt = Integer.parseInt(money);
        if (moneyInt < 1000) {
            throw new IllegalArgumentException(ERROR_MONEY_NOT_OVER_THOUSAND);
        }
        if (moneyInt % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_MONEY_NOT_DIVIDED_WITH_THOUSAND);
        }
    }

    public void isValidatedNormalNumbers(String normalNumbers) {
    }

    public void isValidatedBonusNumber(String bonusNumber) {
    }
}
