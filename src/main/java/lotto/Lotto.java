package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> winningNumbers;
    private int bonus;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplication(numbers);
        this.winningNumbers = numbers;
    }

    public List<Integer> getWinningNumbers() {
        return this.winningNumbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6자리여야 합니다.");
        }
    }

    private void validateRangeOfNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
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
            throw new IllegalArgumentException("[ERROR] 로또 번호는 서로 중복되지 않는 숫자여야 합니다.");
        }
    }

    private void validateDuplicationWithNumbers(int bonus) {
        if (winningNumbers.contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 번호와 중복되지 않은 숫자여야 합니다.");
        }
    }

    public void setBonus(int number) {
        validateRangeOfNumber(number);
        validateDuplicationWithNumbers(number);
        this.bonus = number;
    }

    public int getBonus() {
        return this.bonus;
    }
}
