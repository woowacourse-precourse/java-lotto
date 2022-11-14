package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.LottoConstant.*;
import static lotto.LottoErrorMessage.*;

public class LottoSeller {

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static int receivePurchasePrice() {
        printMessage(PURCHASE_PRICE_MSG);

        return receiveNumber();
    }

    public static List<Integer> receiveWinningNumbers() {
        printMessage(WINNING_NUM_MSG);
        String userInput = Console.readLine();
        validateWinningNumbers(userInput);

        List<String> winningNumbers = Arrays.asList(userInput.split(SEPARATOR));

        return winningNumbers.stream()
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    public static int receiveBonusNumber() {
        printMessage(BONUS_NUM_MSG);

        return receiveNumber();
    }

    private static void validateWinningNumbers(String input) {
        String[] numbers = input.split(SEPARATOR, 0);

        if (numbers.length != LOTTO_SIZE) {
            printMessage(LOTTO_SIZE_ERROR_MSG);
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < numbers.length; i++) {
            validateNumber(numbers[i]);
        }
    }

    private static void validateNumber(String input) {
        if (!input.matches("^[0-9]*$")) {
            printMessage(NUMBER_ERROR_MSG);
            throw new IllegalArgumentException();
        }
    }

    private static int receiveNumber() {
        String userInput = Console.readLine();
        validateNumber(userInput);

        return Integer.parseInt(userInput);
    }
}
