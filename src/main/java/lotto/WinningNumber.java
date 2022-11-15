package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class WinningNumber {
    private final List<Integer> winningNumber;
    private final int bonusNumber;

    public WinningNumber() {
        winningNumber = validateWinningNumber(Console.readLine());
        bonusNumber = validateNumber(Console.readLine());
    }

    private List<Integer> validateWinningNumber(String inputNumbers) {
        List<Integer> winningNumber = new ArrayList<>();
        String[] numbers = inputNumbers.split(",");
        for (String number : numbers) {
            int n = validateNumber(number);
            winningNumber.add(n);
        }

        if (winningNumber.size() != 6) {
            throw new IllegalArgumentException();
        }

        return winningNumber;
    }

    private int validateNumber(String number) {
        int n = convertStringToNumber(number);
        if (isNotValidNumber(n) || isDuplicatedNumber(n)) {
            throw new IllegalArgumentException();
        }
        return n;
    }

    private int convertStringToNumber(String number) {
        try {
            int n = Integer.parseInt(number);
            return n;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNotValidNumber(int n) {
        return n < 1 || n > 45;
    }

    private boolean isDuplicatedNumber(int n) {
        return winningNumber.contains(n);
    }
}
