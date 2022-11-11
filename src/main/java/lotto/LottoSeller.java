package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.LottoConstant.*;
import static lotto.LottoErrorMessage.*;

public class LottoSeller {

    public int receivePurchasePrice() {
        System.out.println(PURCHASE_PRICE_MSG);
        String userInput = receiveUserInput();
        validatePrice(userInput);

        return Integer.parseInt(userInput);
    }

    private void validatePrice(String input) {
        validateNumber(input);
    }

    public WinningLotto createWinningLotto() {
        Lotto winningNumber = new Lotto(receiveWinningNumbers());
        int bonusNumber = receiveBonusNumber();

        return new WinningLotto(winningNumber, bonusNumber);
    }

    private List<Integer> receiveWinningNumbers() {
        System.out.println(WINNING_NUM_MSG);
        String userInput = receiveUserInput();
        validateWinningNumbers(userInput);

        List<String> winningNumbers = Arrays.asList(userInput.split(SEPARATOR));

        return winningNumbers.stream()
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    private void validateWinningNumbers(String input) {
        String[] numbers = input.split(SEPARATOR, 0);

        for (int i = 0; i < numbers.length; i++) {
            validateNumber(numbers[i]);
            int number = Integer.parseInt(numbers[i]);
            validateNumberRange(number);
        }
    }

    private int receiveBonusNumber() {
        System.out.println(BONUS_NUM_MSG);
        String userInput = receiveUserInput();
        validateBonusNumber(userInput);

        return Integer.parseInt(userInput);
    }

    private void validateBonusNumber(String input) {
        validateNumber(input);
        int number = Integer.parseInt(input);
        validateNumberRange(number);
    }

    private void validateNumberRange(int number) {
        if (number < MIN_LOTTO_NUM || number > MAX_LOTTO_NUM) {
            System.out.println(LOTTO_RANGE_ERROR_MSG);
            throw new IllegalArgumentException();
        }
    }

    private void validateNumber(String input) {
        if (!input.matches("^[0-9]*$")) {
            System.out.println(NUMBER_ERROR_MSG);
            throw new IllegalArgumentException();
        }
    }

    private String receiveUserInput() {
        return Console.readLine();
    }
}
