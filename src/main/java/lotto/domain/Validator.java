package lotto.domain;

import lotto.util.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class Validator {
    private static List<Integer> winningNumbers;

    public static int validateMoney(String amount) {
        checkOnlyNumber(amount);
        checkMoneyUnit(amount);
        return Integer.valueOf(amount);
    }

    public static List<Integer> validateLotto(List<Integer> numbers) {
        checkSixNumber(numbers);
        checkDuplicatedNumber(numbers);
        for (int number : numbers) {
            checkRangeOfNumber(number);
        }
        winningNumbers = numbers;
        return numbers;
    }

    public static int validateBonus(String number) {
        int bonusNumber = Integer.valueOf(number);
        checkOnlyNumber(number);
        checkOneNumber(number);
        checkRangeOfNumber(bonusNumber);
        checkDuplicatedBonusNumber(winningNumbers ,bonusNumber);
        return bonusNumber;
    }

    // 숫자로만 이루어졌는지 확인
    public static void checkOnlyNumber(String money) {
        try {
            int amount = Integer.parseInt(money);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_A_NUMBER.printMessage());
        }
    }

    // 1000원 단위인지 확인
    public static void checkMoneyUnit(String money) {
        int amount = Integer.parseInt(money);
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_UNIT.printMessage());
        }
        if (amount < 1000) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_UNIT.printMessage());
        }
    }

    // 6개의 숫자로 이루어졌는지 확인
    public static void checkSixNumber(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.NO_SIX_NUMBER.printMessage());
        }
    }

    // 1부터 45사이의 값인지 확인
    public static void checkRangeOfNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE.printMessage());
        }
    }

    // 6개의 숫자가 중복되는지 확인
    public static void checkDuplicatedNumber(List<Integer> numbers) {
        List<Integer> checkedNumbers = new ArrayList<>();
        for (int number : numbers) {
            if (checkedNumbers.contains(number)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBER.printMessage());
            }
        }
    }

    // 1개의 숫자로 이루어졌는지 확인
    public static void checkOneNumber(String number) {
        if (number.contains(",")) {
            throw new IllegalArgumentException(ErrorMessage.NO_ONE_NUMBER.printMessage());
        }
    }

    // 중복되지 않은 수로 이루어졌는지 확인
    public static void checkDuplicatedBonusNumber(List<Integer> WinningNumbers, int bonus) {
        if (WinningNumbers.contains(bonus)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBER.printMessage());
        }
    }

}
