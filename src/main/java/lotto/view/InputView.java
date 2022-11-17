package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Money;
import lotto.utils.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public static final String SEPARATOR = ",";
    public static final int VALID_SIZE = 6;

    public static Money insertMoney() {
        GuidanceMessage.informToInsertMoney();
        String money = Console.readLine();
        validateMoney(money);

        return new Money(Integer.parseInt(money));
    }

    private static void validateMoney(String money) {
        if (money.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.IS_BLANK);
        }
        if (containsNonNumeric(money)) {
            throw new IllegalArgumentException(ErrorMessage.CONTAINS_NON_NUMERIC_VALUES);
        }
    }

    private static boolean containsNonNumeric(String money) {
        return !money.chars().allMatch(Character::isDigit);
    }

    public static List<Integer> insertWinningNumbers() {
        GuidanceMessage.informToInsertWinningNumbers();
        String numbersWithSeparator = Console.readLine();
        validateWinningNumbers(numbersWithSeparator);

        return getWinningNumbers(numbersWithSeparator);
    }

    private static void validateWinningNumbers(String numbersWithSeparator) {
        if (numbersWithSeparator.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.IS_BLANK);
        }
        if (hasInvalidSize(numbersWithSeparator.split(SEPARATOR))) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_SIZE);
        }
        if (winningNumbersContainsNonNumeric(numbersWithSeparator)) {
            throw new IllegalArgumentException(ErrorMessage.CONTAINS_NON_NUMERIC_VALUES);
        }
    }

    private static boolean winningNumbersContainsNonNumeric(String numbersWithSeparator) {
        String[] numbers = numbersWithSeparator.split(SEPARATOR);

        return Arrays.stream(numbers)
                .anyMatch(number -> containsNonNumeric(number));
    }

    private static boolean hasInvalidSize(String[] separatedNumbers) {
        return separatedNumbers.length != VALID_SIZE;
    }

    public static int insertBonusNumber() {
        GuidanceMessage.informToInsertBonusNumber();
        String bonusNumber = Console.readLine();

        return Integer.parseInt(bonusNumber);
    }

    private static List<Integer> getWinningNumbers(String numbersWithSeparator) {
        String[] winningNumbers = numbersWithSeparator.split(SEPARATOR);
        return Arrays.stream(winningNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
