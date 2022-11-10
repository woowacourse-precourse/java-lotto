package lotto.utils;

import lotto.domain.ErrorStatus;
import lotto.domain.InputView;

import java.util.List;

public class Validation {
    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final int LOTTO_FIRST_NUMBER = 1;
    private static final int LOTTO_LAST_NUMBER = 45;

    public static void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
        validateNumber(numbers);
    }

    private static void validateNumber(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LOTTO_FIRST_NUMBER || number > LOTTO_LAST_NUMBER) {
                throw new IllegalArgumentException(ErrorStatus.OUT_OF_RANGE_NUMBER.printError());
            }
        }
    }

    private static void validateDuplication(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(ErrorStatus.NUMBER_DUPLICATION.printError());
        }
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(ErrorStatus.NUMBERS_SIZE.printError());
        }
    }

    public static void validateMoney(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException(ErrorStatus.MONEY_RANGE.printError());
        }
    }

    public static void validateInputMoney(String inputMoney) {
        try {
            Integer.parseInt(inputMoney);
        } catch (IllegalArgumentException error) {
            System.out.println(ErrorStatus.NOT_NUMBER.printError());
            InputView.inputPurchasePrice();
        }
    }

    public static void validateWinningNumbers(String[] inputWinningNumbers) {
        try {
            for (String inputWinningNumber : inputWinningNumbers) {
                Integer.parseInt(inputWinningNumber);
            }
        } catch (IllegalArgumentException error) {
            System.out.println(ErrorStatus.NOT_NUMBER.printError());
            InputView.inputWinningNumbers();
        }
    }
}
