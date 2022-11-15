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
        bonusNumber = validateNumber(Console.readLine());
    }

    private static void printRequestWinningNumberMessage() {
        System.out.println(REQUEST_WINNING_NUMBER_MESSAGE);
    }

    private static void printRequestBonusNumberMessage() {
        System.out.println(REQUEST_BONUS_NUMBER_MESSAGE);
    }

    private static int convertStringToNumber(String number) {
        try {
            int n = Integer.parseInt(number);
            return n;
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.PARSING_NUMBER_ERROR.getMessage());
        }
    }

    private static boolean isNotValidNumber(int n) {
        return n < 1 || n > 45;
    }

    private List<Integer> validateWinningNumber(String inputNumbers) {
        List<Integer> winningNumber = new ArrayList<>();
        String[] numbers = inputNumbers.split(",");
        for (String n : numbers) {
            ;
            winningNumber.add(validateNumber(n));
        }

        if (winningNumber.size() != 6) {
            throw new IllegalArgumentException();
        }

        return winningNumber;
    }

    private int validateNumber(String number) {
        int n = convertStringToNumber(number);
        if (isNotValidNumber(n)) {
            throw new IllegalArgumentException(ErrorMessage.NUMERIC_RANGE_ERROR.getMessage());
        }
        if (isDuplicatedNumber(n)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBER_ERROR.getMessage());
        }
        return n;
    }

    private boolean isDuplicatedNumber(int n) {
        return numbers.contains(n);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
