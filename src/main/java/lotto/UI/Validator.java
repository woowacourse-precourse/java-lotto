package lotto.UI;

import java.util.List;
import java.util.regex.Pattern;

public class Validator {

    private static final String ERROR_INPUT_IS_NOT_NUMBER= "[ERROR] 입력값이 숫자가 아닙니다.";
    private static final String ERROR_MONEY_NOT_OVER_THOUSAND= "[ERROR] 로또 구입 금액은 1000원 이상이어야합니다. ";
    private static final String ERROR_MONEY_NOT_DIVIDED_WITH_THOUSAND= "[ERROR] 로또 구입 금액은 1000으로 나누어 떨어져야합니다. ";
    private static final String ERROR_NUMBER_IS_NOT_IN_RANGE_FROM_ONE_TO_FOURTYFIVE = "[ERROR] 숫자의 범위는 1에서 45 사이여야합니다.";
    private static final String ERROR_NUMBERS_ARE_NOT_CONSISTS_OF_SIX = "[ERROR] 6자리로 구성된 숫자가 아닙니다.";


    public void validateMoney(String money) {

        validateConsistOfNumber(money);

        int moneyInt = Integer.parseInt(money);
        if (moneyInt < 1000) {
            throw new IllegalArgumentException(ERROR_MONEY_NOT_OVER_THOUSAND);
        }
        if (moneyInt % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_MONEY_NOT_DIVIDED_WITH_THOUSAND);
        }
    }

    public void validateNormalNumbers(String normalNumbers) {
        List<String> numbersInString = List.of(normalNumbers.split(","));

        for (String number : numbersInString) {
            validateConsistOfNumber(number);
            validateProperRangeOfNumber(Integer.parseInt(number));
        }
        validateConsistOfSixNumbers(normalNumbers);
    }


    public void validateBonusNumber(String bonusNumber) {
        validateConsistOfNumber(bonusNumber);
        validateProperRangeOfNumber(Integer.parseInt(bonusNumber));
    }

    private void validateConsistOfNumber(String string) {
        if (!Pattern.matches("[0-9]*]", string)) {
            throw new IllegalArgumentException(ERROR_INPUT_IS_NOT_NUMBER);
        }
    }

    private void validateProperRangeOfNumber(int parseInt) {
        if (parseInt < 1 || parseInt > 45) {
            throw new IllegalArgumentException(ERROR_NUMBER_IS_NOT_IN_RANGE_FROM_ONE_TO_FOURTYFIVE);
        }
    }
    private void validateConsistOfSixNumbers(String normalNumbers) {
        if (normalNumbers.length() != 6) {
            throw new IllegalArgumentException(ERROR_NUMBERS_ARE_NOT_CONSISTS_OF_SIX);
        }
    }
}
