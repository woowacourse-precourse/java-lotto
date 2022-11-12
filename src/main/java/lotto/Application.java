package lotto;

import static lotto.domain.constant.IntValueConstant.LOTTO_MAXIMUM_NUMBER;
import static lotto.domain.constant.IntValueConstant.LOTTO_MINIMUM_NUMBER;
import static lotto.domain.constant.IntValueConstant.LOTTO_NUMBER_OF_DIGITS;
import static lotto.exception.ExceptionHandler.ILLEGAL_RANGE;
import static lotto.exception.ExceptionHandler.ILLEGAL_VALUE;
import static lotto.exception.ExceptionHandler.INPUT_SIX_DIGITS;
import static lotto.exception.ExceptionHandler.OVERLAP_NUMBER;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.domain.Buyer;

public class Application {

    public static void main(String[] args) {
        Buyer buyer = new Buyer();
        buyer.readyForBuyLotto();
        buyer.buyLotto();

        List<Integer> winningNumbers = createWinningNumbers();
        validateNumbers(winningNumbers);
        List<Integer> bonusNumber = createBonusNumber(winningNumbers);
    }

    private static List<Integer> createBonusNumber(List<Integer> winningNumbers) {
        try {
            List<Integer> bonusNumber = Collections.singletonList(Integer.parseInt(Console.readLine()));

            validateRangeNumbers(bonusNumber);
            validateOverlapBonusNumberWithWinningNumbers(bonusNumber, winningNumbers);

            return bonusNumber;

        } catch (NumberFormatException exception) {
            ILLEGAL_VALUE.error();
        }

        return Collections.emptyList();
    }

    private static void validateOverlapBonusNumberWithWinningNumbers(List<Integer> bonusNumber,
            List<Integer> winningNumbers) {

        for (Integer winningNumber : winningNumbers) {
            if (Objects.equals(winningNumber, bonusNumber.get(0))) {
                OVERLAP_NUMBER.error();
            }
        }
    }

    private static List<Integer> createWinningNumbers() {
        String inputValues = Console.readLine();

        return Arrays.stream(inputValues.split(","))
                     .map(Integer::parseInt)
                     .collect(Collectors.toList());
    }

    private static void validateNumbers(List<Integer> numbers) {
        validateRangeNumbers(numbers);
        validateOverlapWinningNumbers(numbers);

        if (numbers.size() != LOTTO_NUMBER_OF_DIGITS.getValue()) {
            INPUT_SIX_DIGITS.error();
        }
    }


    private static void validateRangeNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < LOTTO_MINIMUM_NUMBER.getValue() || number > LOTTO_MAXIMUM_NUMBER.getValue()) {
                ILLEGAL_RANGE.error();
            }
        }
    }

    private static void validateOverlapWinningNumbers(List<Integer> winningNumbers) {
        Set<Integer> enteredWinningNumbers = new HashSet<>(winningNumbers);

        if (enteredWinningNumbers.size() != LOTTO_NUMBER_OF_DIGITS.getValue()) {
            OVERLAP_NUMBER.error();
        }
    }

}
