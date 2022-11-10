package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.LottoMachine.*;

public class LottoSeller {
    private static final String NUM_ERROR_MSG = "[ERROR] 숫자만 입력해주세요";
    private static final String RANGE_ERROR_MSG = "[ERROR] 1~45 사이의 숫자를 입력해주세요";
    private static final String PURCHASE_PRICE_MSG = "구매금액을 입력해 주세요.";
    private static final String WINNING_NUM_MSG = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUM_MSG = "보너스 번호를 입력해 주세요.";
    private static final String SEPARATOR = ",";

    public int receivePurchasePrice() {
        System.out.println(PURCHASE_PRICE_MSG);
        String userInput = receiveUserInput();
        validatePrice(userInput);

        return Integer.parseInt(userInput);
    }

    private void validatePrice(String input) {
        validateNumber(input);
    }

    public List<Integer> receiveWinningNumbers() {
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

    private void validateNumberRange(int number) {
        if (number < MIN_LOTTO_NUM || number > MAX_LOTTO_NUM) {
            System.out.println(RANGE_ERROR_MSG);
            throw new IllegalArgumentException();
        }
    }

    private void validateNumber(String input){
        if (!input.matches("^[0-9]*$")) {
            System.out.println(NUM_ERROR_MSG);
            throw new IllegalArgumentException();
        }
    }

    private String receiveUserInput() {
        return Console.readLine();
    }
}
