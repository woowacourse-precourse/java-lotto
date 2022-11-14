package lotto.service;

import static lotto.Constants.MAXIMUM_WINNING_NUMBER;
import static lotto.Constants.MINIMUM_WINNING_NUMBER;
import static lotto.Constants.WINNING_NUMBERS_IS_NOT_IN_RANGE_ERROR_MESSAGE;
import static lotto.Constants.WINNING_NUMBERS_IS_NOT_NUMBER_ERROR_MESSAGE;
import static lotto.Constants.WINNING_NUMBERS_SEPARATOR;
import static lotto.Constants.WINNING_NUMBERS_SIZE;
import static lotto.Constants.WINNING_NUMBERS_SIZE_IS_INVALID_ERROR_MESSAGE;

public class ResultService {
    private static ResultService instance;

    private ResultService() {
    }

    public static ResultService getInstance() {
        if (instance == null) {
            instance = new ResultService();
        }
        return instance;
    }

    public void validate(String winningNumbers) {
        String[] numbers = winningNumbers.split(WINNING_NUMBERS_SEPARATOR);
        for (String number : numbers) {
            validateNumber(number);
        }
        if (numbers.length != WINNING_NUMBERS_SIZE) {
            throw new IllegalArgumentException(WINNING_NUMBERS_SIZE_IS_INVALID_ERROR_MESSAGE);
        }
    }

    public void validateNumber(String number) {
        if (!number.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(WINNING_NUMBERS_IS_NOT_NUMBER_ERROR_MESSAGE);
        }
        int parsed = Integer.parseInt(number);
        if (parsed <= MINIMUM_WINNING_NUMBER || parsed >= MAXIMUM_WINNING_NUMBER) {
            throw new IllegalArgumentException(WINNING_NUMBERS_IS_NOT_IN_RANGE_ERROR_MESSAGE);
        }
    }
}
