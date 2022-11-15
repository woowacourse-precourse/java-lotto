package lotto.utils;

import static lotto.constant.LottoGameRule.SEPARATOR;
import static lotto.utils.ErrorMessage.NOT_NUMBER_ERROR;
import static lotto.utils.ErrorMessage.WINNING_INPUT_NUMBER_ERROR;

import java.util.ArrayList;
import java.util.List;

public class WinningNumberSplit {
    public static List<Integer> splitWinningNumber(String input) {
        List<String> numbers = List.of(input.split(SEPARATOR));
        List<Integer> winningNumbers = new ArrayList<>();
        getWinningNumber(numbers, winningNumbers);
        return winningNumbers;
    }

    private static void getWinningNumber(List<String> numbers, List<Integer> winningNumbers) {
        for (String number : numbers) {
            if (InputValidator.isBlank(number)) {
                throw new IllegalArgumentException(WINNING_INPUT_NUMBER_ERROR.toString());
            }
            if (InputValidator.isNotNumber(number)) {
                throw new IllegalArgumentException(NOT_NUMBER_ERROR.toString());
            }
            winningNumbers.add(Integer.parseInt(number));
        }
    }
}