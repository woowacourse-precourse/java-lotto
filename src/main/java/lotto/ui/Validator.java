package lotto.ui;

import lotto.exception.IllegalLottoNumberException;
import lotto.exception.IllegalMoneyException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Validator {

    private static final String ERROR_INPUT_IS_NOT_NUMBER = "[ERROR] 입력값이 숫자가 아닙니다.";
    private static final String ERROR_MONEY_NOT_OVER_THOUSAND = "[ERROR] 로또 구입 금액은 1000원 이상이어야합니다. ";
    private static final String ERROR_MONEY_NOT_DIVIDED_WITH_THOUSAND = "[ERROR] 로또 구입 금액은 1000으로 나누어 떨어져야합니다. ";
    private static final String ERROR_NUMBER_IS_NOT_IN_RANGE_FROM_ONE_TO_FORTY_FIVE = "[ERROR] 숫자의 범위는 1에서 45 사이여야합니다.";
    private static final String ERROR_NUMBERS_ARE_NOT_CONSISTS_OF_SIX = "[ERROR] 6자리로 구성된 숫자가 아닙니다.";
    private static final String ERROR_BONUS_NUMBER_DUPLICATED = "[ERROR] 보너스 번호 중복입니다.";

    public void validateMoney(String money) {
        validateConsistOfNumber(money);
        validateMoneyOverThousand(money);
        validateMoneyDividedByThousand(money);
    }

    public void validateNormalNumbers(String normalNumbers) {
        List<Integer> numbers = transformNumberAsInteger(normalNumbers);
        for (Integer number : numbers) {
            validateProperRangeOfNumber(number);
        }
        validateConsistOfSixNumbers(numbers);
        validateNotDuplicatedNumber(numbers);
    }

    public void validateBonusNumber(List<Integer> normalNumbers, String bonusNumber) {
        validateConsistOfNumber(bonusNumber);
        validateProperRangeOfNumber(Integer.parseInt(bonusNumber));
        normalNumbers.add(Integer.parseInt(bonusNumber));
        validateNotDuplicatedNumber(normalNumbers);
    }

    private void validateNotDuplicatedNumber(List<Integer> numbers) {
        int originalSize = numbers.size();
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (originalSize != numberSet.size()) {
            System.out.println(ERROR_BONUS_NUMBER_DUPLICATED);
            throw new IllegalLottoNumberException();
        }
    }

    private void validateConsistOfNumber(String string) {
        if (!Pattern.matches("[0-9]+", string)) {
            System.out.println(ERROR_INPUT_IS_NOT_NUMBER);
            throw new IllegalLottoNumberException(ERROR_INPUT_IS_NOT_NUMBER);
        }
    }

    private void validateProperRangeOfNumber(int parseInt) {
        if (parseInt < 1 || parseInt > 45) {
            System.out.println(ERROR_NUMBER_IS_NOT_IN_RANGE_FROM_ONE_TO_FORTY_FIVE);
            throw new IllegalLottoNumberException();
        }
    }

    private void validateConsistOfSixNumbers(List<Integer> numbersInString) {
        if (numbersInString.size() != 6) {
            System.out.println(ERROR_NUMBERS_ARE_NOT_CONSISTS_OF_SIX);
            throw new IllegalLottoNumberException();
        }
    }

    private List<Integer> transformNumberAsInteger(String normalNumbers) {
        List<String> numbersInString = List.of(normalNumbers.split(","));
        List<Integer> numbersInInteger = new ArrayList<>();
        for (String numberInString : numbersInString) {
            validateConsistOfNumber(numberInString);
        }
        for (String number : numbersInString) {
            numbersInInteger.add(Integer.parseInt(number));
        }
        return numbersInInteger;
    }

    private void validateMoneyOverThousand(String money) {
        int moneyInt = Integer.parseInt(money);
        if (moneyInt < 1000) {
            System.out.println(ERROR_MONEY_NOT_OVER_THOUSAND);
            throw new IllegalMoneyException(ERROR_MONEY_NOT_OVER_THOUSAND);
        }
    }

    private void validateMoneyDividedByThousand(String money) {
        int moneyInt = Integer.parseInt(money);
        if (moneyInt % 1000 != 0) {
            System.out.println(ERROR_MONEY_NOT_DIVIDED_WITH_THOUSAND);
            throw new IllegalMoneyException(ERROR_MONEY_NOT_DIVIDED_WITH_THOUSAND);
        }
    }
}
