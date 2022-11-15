package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumber {

    public static final int NUMBER_OF_WINNING_NUMBERS = 6;

    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningNumber(List<Integer> numbers, int bonusNumber) {
        validateWinningNumbers(numbers);
        validateBonusNumber(bonusNumber, numbers);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateWinningNumbers(List<Integer> numbers) {
        validateWinningNumbersSize(numbers);
        validateWinningNumbersRange(numbers);
        validateWinningNumbersDuplicate(numbers);
    }

    private void validateWinningNumbersSize(List<Integer> numbers) {
        if (numbers.size() != NUMBER_OF_WINNING_NUMBERS) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호의 개수는 " + NUMBER_OF_WINNING_NUMBERS + "개입니다.");
        }
    }

    private void validateWinningNumbersRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1이상 45이하 범위의 숫자이어야 합니다.");
            }
        }
    }

    private void validateWinningNumbersDuplicate(List<Integer> integerNumbers) {
        Set<Integer> deduplicatedIntegerNumbers = new HashSet<>(integerNumbers);
        if (deduplicatedIntegerNumbers.size() != integerNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 존재합니다.");
        }
    }

    private void validateBonusNumber(int bonusNumber, List<Integer> numbers) {
        validateBonusNumberRange(bonusNumber);
        validateBonusNumberDuplicate(bonusNumber, numbers);
    }

    private void validateBonusNumberRange(int integerInput) {
        if (integerInput < 1 || integerInput > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1이상 45이하 범위의 숫자이어야 합니다.");
        }
    }

    private void validateBonusNumberDuplicate(int integerInput, List<Integer> numbers) {
        if (numbers.contains(integerInput)) {
            throw new IllegalArgumentException("[ERROR] 중복되는 숫자가 존재합니다.");
        }
    }

    public int countMatch(Lotto lotto) {
        int count = 0;
        for (int number : numbers) {
            count += lotto.containNumber(number);
        }
        return count;
    }

    public boolean isBonus(Lotto lotto) {
        if (lotto.containNumber(bonusNumber) == 1) {
            return true;
        }
        return false;
    }
}
