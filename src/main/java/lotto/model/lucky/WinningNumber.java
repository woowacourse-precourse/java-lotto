package lotto.model.lucky;

import java.util.List;
import java.util.ArrayList;

import lotto.TryCatchException;

public class WinningNumber {

    private static final int COUNT_OF_WINNING_NUMBERS = 6;
    private static final int COUNT_OF_DELIMITER = 5;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int NEGATIVE_SIGN = '-';
    private static final int DELIMITER = ',';
    private List<Integer> winningNumbers;

    public WinningNumber(String winningNumber) {
        checkNull(winningNumber);
        validateSign(winningNumber);
        validateDelimiters(winningNumber);
        validateNumbers(winningNumber);
        initializeWinningNumbers(winningNumber);
    }

    private void checkNull(String input) {
        try {
            if (input == null) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new TryCatchException("[ERROR] The winning number must consists validate numbers.");
        }
    }

    private void validateSign(String input) {
        long count = input.chars()
                .filter(this::isSign)
                .count();

        try {
            if (count != 0) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new TryCatchException("[ERROR] The winning number must be positive.");
        }
    }

    private void validateDelimiters(String input) {
        long count = input.chars()
                .filter(this::isDelimiter)
                .count();

        try {
            if (count != COUNT_OF_DELIMITER) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new TryCatchException("[ERROR] The delimiter must be in correct format.");
        }
    }

    private void validateNumbers(String input) {
        long count = transformToInteger(input)
                .stream()
                .filter(i -> MIN_LOTTO_NUMBER <= i && i <= MAX_LOTTO_NUMBER)
                .distinct()
                .count();
        try {
            if (count != COUNT_OF_WINNING_NUMBERS) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new TryCatchException("[ERROR] The winning number must consists validate numbers.");
        }
    }

    public static List<Integer> transformToInteger(String input) {
        List<Integer> inputNumbers = new ArrayList<>();
        try {
            for (String s : input.split(Character.toString(DELIMITER))) {
                inputNumbers.add(Integer.parseInt(s));
            }
        } catch (NumberFormatException e) {
            throw new TryCatchException("[ERROR] The winning number must consists validate numbers.");
        }
        return inputNumbers;
    }

    private void initializeWinningNumbers(String winningNumber) {
        this.winningNumbers = new ArrayList<>();
        for (String s : winningNumber.split(Character.toString(DELIMITER))) {
            winningNumbers.add(Integer.parseInt(s));
        }
    }

    public boolean isSign(int c) {
        return c == NEGATIVE_SIGN;
    }

    private boolean isDelimiter(int c) {
        return c == DELIMITER;
    }

    public boolean contains(Integer number) {
        return winningNumbers.contains(number);
    }
}
