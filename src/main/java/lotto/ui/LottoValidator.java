package lotto.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.ui.ErrorMessage.*;
import static lotto.util.LogLevel.ERROR;

public class LottoValidator {

    public void validatePrice(String price) {
        if (!isNumeric(price) || !isMultiple(Integer.parseInt(price), 1000)) {
            throw new IllegalArgumentException(INVALID_INPUT_PRICE.toMessage(ERROR));
        }
    }

    public void validateWinningNumbers(String winningNumber) {
        List<String> winningNumbers = Arrays.stream(winningNumber.split(","))
                .collect(Collectors.toUnmodifiableList());

        if (!isLengthSix(winningNumbers) || !isNumeric(winningNumbers) || !isValidLottoRange(winningNumbers)) {
            throw new IllegalArgumentException(INVALID_INPUT_WINNING_NUMBERS.toMessage(ERROR));
        }

        if (isDuplication(winningNumbers.stream().map(Integer::parseInt).collect(Collectors.toList()))) {
            throw new IllegalArgumentException(LOTTO_DUPLICATION.toMessage(ERROR));
        }
    }

    public void validateBonusNumber(String bonusNumber) {
        if (!isNumeric(bonusNumber) || !isValidLottoRange(bonusNumber)) {
            throw new IllegalArgumentException(INVALID_INPUT_WINNING_NUMBERS.toMessage(ERROR));
        }
    }

    public static void validateBonusNumberDuplication(String winningNumbers, String bonusNumber) {
        List<String> winningNumbersAndBonus = new ArrayList<>(Arrays.stream(winningNumbers.split(","))
                .collect(Collectors.toUnmodifiableList()));
        winningNumbersAndBonus.add(bonusNumber);

        if (isDuplication(winningNumbersAndBonus.stream().map(Integer::parseInt).collect(Collectors.toUnmodifiableList()))) {
            throw new IllegalArgumentException(LOTTO_DUPLICATION.toMessage(ERROR));
        }
    }

    public static boolean isDuplication(List<Integer> numbers) {
        int targetLength = numbers.size();
        Set<Integer> compare = numbers.stream().collect(Collectors.toUnmodifiableSet());

        return targetLength != compare.size();
    }

    private boolean isNumeric(List<String> input) {
        try {
            for (String s : input) {
                Integer.parseInt(s);
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isMultiple(int target, int divisor) {
        return (target % divisor) == 0;
    }

    private boolean isValidLottoRange(List<String> input) {
        for (String s : input) {
            if (!isValidLottoRange(s)) {
                return false;
            }
        }

        return true;
    }

    private boolean isValidLottoRange(String input) {
        int inputNumber = Integer.parseInt(input);

        return inputNumber >= 1 && inputNumber <= 45;
    }

    private boolean isLengthSix(List<String> input) {
        return input.size() == 6;
    }
}
