package lotto;

import java.util.HashSet;
import java.util.List;

import static lotto.Constants.*;

public class Lotto {
    private final List<Integer> winningNumbers;
    private int bonus;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplication(numbers);
        this.winningNumbers = numbers;
    }


    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != NUM_OF_LOTTO) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_SIZE);
        }
    }

    private void validateRangeOfNumber(int number) {
        if (number < MIN_VALUE_OF_LOTTO || number > MAX_VALUE_OF_LOTTO) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_RANGE_OF_NUMBER);
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateRangeOfNumber(number);
        }
    }

    private int getNumsOfUniqueNumber(List<Integer> numbers) {
        return new HashSet<Integer>(numbers).size();
    }

    private void validateDuplication(List<Integer> numbers) {
        int numsOfUniqueNumber = getNumsOfUniqueNumber(numbers);
        if (numbers.size() != numsOfUniqueNumber) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_DUPLICATION);
        }
    }

    private void validateDuplicationWithWinningNumbers(int bonus) {
        if (winningNumbers.contains(bonus)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_DUPLICATION_WITH_WINNING_NUMBER);
        }
    }

    private void validateRangeOfBonusNumber(int number) {
        if (number < MIN_VALUE_OF_LOTTO || number > MAX_VALUE_OF_LOTTO) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_RANGE_OF_BONUS_NUMBER);
        }
    }

    public void setBonus(int number) {
        validateRangeOfBonusNumber(number);
        validateDuplicationWithWinningNumbers(number);
        this.bonus = number;
    }

    public int getBonus() {
        return this.bonus;
    }

    public List<Integer> getWinningNumbers() {
        return this.winningNumbers;
    }
}
