package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class WinningInput {
    public static String winningNumber;
    public static int[] winningIntArr;
    public static List<Integer> winningNumbers;
    public static int winningCount;

    public static void winningNumberInput() {
        System.out.println(Message.WINNING_NUMBER_INPUT.getMessage());
        winningNumber = readLine();
        validateWinningNumber(winningNumber);
        validateWinningNumberSize(winningNumber);
        validateInputBlank(winningNumber);
        validateInputSeparator(winningNumber);
    }

    public static int[] winningNumberToInt(String winningNumber) {
        String[] winningStringArr = winningNumber.split(",");
        winningIntArr = new int[winningStringArr.length];
        for (int i = 0; i < winningStringArr.length; i++) {
            winningIntArr[i] = Integer.parseInt(winningStringArr[i]);
        }
        return winningIntArr;
    }

    public static List<Integer> winningIntArrToList(int[] winningIntArr) {
        winningNumbers = new ArrayList<>(winningIntArr.length);
        for (int i : winningIntArr) {
            winningNumbers.add(i);
        }
        return winningNumbers;
    }

    public static int getWinningResult(List<List<Integer>> lottos, List<Integer> winningNumbers) {
        Map<List<Integer>, Integer> map = new HashMap<>();
        for (List<Integer> check : lottos) {
            winningCount = 0;
            checkCount(check, winningNumbers, map);
        }
        winningCount = Collections.max(map.values());
        return winningCount;
    }

    public static void checkCount(List<Integer> check, List<Integer> winningNumbers, Map<List<Integer>, Integer> map) {
        for (int i = 0; i < check.size(); i++) {
            if (check.contains(winningNumbers.get(i))) {
                winningCount++;
                map.put(check, winningCount);
            }
        }
    }

    private static void validateWinningNumber(String winningNumber) {
        Integer[] winningNumberArr = Stream.of(winningNumber.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toArray(Integer[]::new);
        for (Integer number : winningNumberArr) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ErrorMessage.ERROR_NUMBER_RANGE.getErrorMessage());
            }
        }
    }

    private static void validateWinningNumberSize(String winningNumber) {
        String[] numberSizeCheck = winningNumber.split(",");
        if (numberSizeCheck.length != 6) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_LOTTO_LENGTH.getErrorMessage());
        }
    }

    private static void validateInputBlank(String winningNumber) {
        for (int i = 0; i < winningNumber.length(); i++) {
            if (winningNumber.charAt(i) == ' ') {
                throw new IllegalArgumentException(ErrorMessage.ERROR_BLANK.getErrorMessage());
            }
        }
    }

    private static void validateInputSeparator(String winningNumber) {
        String[] separatorCheck = winningNumber.split(",");
        if (separatorCheck.length != 6) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_SEPARATOR.getErrorMessage());
        }
    }
}
