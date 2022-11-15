package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

import static lotto.Validator.*;

public class WinningNumber {
    private static final String REQUEST_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningNumber() {
        printRequestWinningNumberMessage();
        numbers = validateWinningNumber(Console.readLine());

        printRequestBonusNumberMessage();
        int number = Formatter.convertStringToNumber(Console.readLine());
        bonusNumber = validateNumber(numbers, number);
    }

    private static void printRequestWinningNumberMessage() {
        System.out.println(REQUEST_WINNING_NUMBER_MESSAGE);
    }

    private static void printRequestBonusNumberMessage() {
        System.out.println(REQUEST_BONUS_NUMBER_MESSAGE);
    }

    private List<Integer> validateWinningNumber(String inputNumbers) {
        List<Integer> winningNumber = new ArrayList<>();
        int[] numbers = Formatter.convertStringToNumbers(inputNumbers);
        for (int n : numbers) {
            winningNumber.add(validateNumber(winningNumber, n));
        }

        checkNumbersCount(winningNumber.size());
        return winningNumber;
    }

    private int validateNumber(List<Integer> numbers, int number) {
        checkNotValidNumber(number);
        checkDuplicatedNumber(numbers, number);
        return number;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
