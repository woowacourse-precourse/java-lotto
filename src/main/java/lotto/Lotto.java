package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    public String getNumbersToString() {
        return numbers.toString();
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또는 6자리 수로 이뤄져야합니다. numbers: " + numbers);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);

        if (numbers.size() != set.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 값이 존재합니다. numbers: " + numbers);
        }
    }

    public int matchCountOfWinningNumbers(List<Integer> winningNumbers) {
        int winNumber = 0;

        for (int number : numbers) {
            if (winningNumbers.contains(number)) {
                winNumber += 1;
            }
        }

        return winNumber;
    }

    public boolean isMatchBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
