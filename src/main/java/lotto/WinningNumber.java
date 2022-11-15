package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class WinningNumber {
    private static final String REQUEST_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningNumber() {
        printRequestWinningNumberMessage();
        numbers = validateWinningNumber(Console.readLine());

        printRequestBonusNumberMessage();
        bonusNumber = validateNumber(numbers, Console.readLine());
    }

    private static void printRequestWinningNumberMessage() {
        System.out.println(REQUEST_WINNING_NUMBER_MESSAGE);
    }

    private static void printRequestBonusNumberMessage() {
        System.out.println(REQUEST_BONUS_NUMBER_MESSAGE);
    }

    private List<Integer> validateWinningNumber(String inputNumbers) {
        List<Integer> winningNumber = new ArrayList<>();
        String[] numbers = inputNumbers.split(",");
        for (String n : numbers) {
            winningNumber.add(validateNumber(winningNumber, n));
        }

        if (winningNumber.size() != 6) {
            throw new IllegalArgumentException();
        }

        return winningNumber;
    }

    private int validateNumber(List<Integer> numbers, int number) {
        if (Validator.isNotValidNumber(number)) {
            throw new IllegalArgumentException(ErrorMessage.NUMERIC_RANGE_ERROR.getMessage());
        }
        if (Validator.isDuplicatedNumber(numbers, number)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBER_ERROR.getMessage());
        }
        return number;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
