package lotto.model.lucky;

import java.util.ArrayList;

import java.util.List;
import lotto.TryCatchException;


public class WinningNumber {

    private static final int COUNT_OF_WINNING_NUMBERS = 6;
    private static final int COUNT_OF_DELIMITER = 5;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int DELIMITER = ',';
    private List<Integer> winningNumbers;

    public WinningNumber(String winningNumber) {
        checkNull(winningNumber);
        validateNumbers(winningNumber);
        validateDelimiters(winningNumber);
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

    private void validateNumbers(String input) {
        long count = input.chars()
            .filter(Character::isDigit)
            .map(Character::getNumericValue)
            .filter(i -> i >= MIN_LOTTO_NUMBER)
            .filter(i -> i <= MAX_LOTTO_NUMBER)
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

    private boolean isDelimiter(int c) {
        return c == DELIMITER;
    }

    private void initializeWinningNumbers(String winningNumber) {
        this.winningNumbers = new ArrayList<>();
        for (String s : winningNumber.split(Character.toString(DELIMITER))) {
            winningNumbers.add(Integer.parseInt(s));
        }
    }

    public boolean contains(Integer number) {
        return winningNumbers.contains(number);
    }
}
