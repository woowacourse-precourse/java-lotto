package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import lotto.domain.ErrorMessage;
import lotto.domain.Message;

public class WinningInput {
    public static String winningInput;
    public static List<Integer> winningNumbers;
    private static int[] winningIntArr;

    public static void inputWinningNumber() {
        System.out.println(Message.WINNING_NUMBER_INPUT.getMessage());
        winningInput = readLine();
        validateWinningNumberException();
        System.out.println();
        winningNumberToInt(winningInput);
        winningIntArrToList(winningIntArr);
    }

    private static void winningNumberToInt(String winningInput) {
        String[] winningStringArr = winningInput.split(",");
        winningIntArr = new int[winningStringArr.length];
        for (int i = 0; i < winningStringArr.length; i++) {
            winningIntArr[i] = Integer.parseInt(winningStringArr[i]);
        }
    }

    private static void winningIntArrToList(int[] winningIntArr) {
        winningNumbers = new ArrayList<>(winningIntArr.length);
        for (int i : winningIntArr) {
            winningNumbers.add(i);
        }
    }

    private static void validateWinningNumberException() {
        validateInputString(winningInput);
        validateInputSeparator(winningInput);
        validateWinningNumber(winningInput);
        validateWinningNumberSize(winningInput);
    }

    private static void validateWinningNumber(String winningInput) {
        Integer[] winningNumberArr = Stream.of(winningInput.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toArray(Integer[]::new);
        for (Integer number : winningNumberArr) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ErrorMessage.ERROR_NUMBER_RANGE.getErrorMessage());
            }
        }
    }

    private static void validateInputString(String winningInput) {
        String[] numberStringCheck = winningInput.split(",");
        for (String number : numberStringCheck) {
            if (number.charAt(0) < '0' || number.charAt(0) > '9') {
                throw new IllegalArgumentException(ErrorMessage.ERROR_WINNING_NUMBER.getErrorMessage());
            }
        }
    }

    private static void validateWinningNumberSize(String winningInput) {
        String[] numberSizeCheck = winningInput.split(",");
        if (numberSizeCheck.length != 6) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_LOTTO_LENGTH.getErrorMessage());
        }
    }

    private static void validateInputSeparator(String winningInput) {
        if (!winningInput.contains(",")) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_SEPARATOR.getErrorMessage());
        }
    }
}
