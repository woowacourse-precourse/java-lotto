package lotto;

import static lotto.domain.constant.IntValueConstant.LOTTO_MAXIMUM_NUMBER;
import static lotto.domain.constant.IntValueConstant.LOTTO_MINIMUM_NUMBER;
import static lotto.domain.constant.IntValueConstant.LOTTO_NUMBER_OF_DIGITS;
import static lotto.exception.ErrorMessagePrinter.ILLEGAL_RANGE;
import static lotto.exception.ErrorMessagePrinter.INPUT_SIX_DIGITS;
import static lotto.exception.ErrorMessagePrinter.OVERLAP_NUMBER;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.domain.Buyer;

public class Application {

    public static void main(String[] args) {
        Buyer buyer = new Buyer();
        buyer.readyForBuyLotto();
        buyer.buyLotto();

        List<Integer> winningNumbers = createWinningNumbers();
        validateWinningNumbers(winningNumbers);
    }

    private static List<Integer> createWinningNumbers() {
        String inputValues = Console.readLine();

        return Arrays.stream(inputValues.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void validateWinningNumbers(List<Integer> winningNumbers) {
        validateRangeNumbers(winningNumbers);
        validateOverlapNumbers(winningNumbers);

        if (winningNumbers.size() != LOTTO_NUMBER_OF_DIGITS.getValue()) {
            INPUT_SIX_DIGITS.error();
        }
    }


    private static void validateRangeNumbers(List<Integer> winningNumbers) {
        for (Integer winningNumber : winningNumbers) {
            if (winningNumber < LOTTO_MINIMUM_NUMBER.getValue() || winningNumber > LOTTO_MAXIMUM_NUMBER.getValue()) {
                ILLEGAL_RANGE.error();
            }
        }
    }

    private static void validateOverlapNumbers(List<Integer> winningNumbers) {
        Set<Integer> enteredWinningNumbers = new HashSet<>(winningNumbers);

        if (enteredWinningNumbers.size() != LOTTO_NUMBER_OF_DIGITS.getValue()) {
            OVERLAP_NUMBER.error();
        }
    }

}
