package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Win {

    private final List<Integer> numbers;

    public Win(List<Integer> winningNumbers) {
        validate(winningNumbers);
        this.numbers = winningNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호의 개수는 6개여야 합니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> duplicationSet = new HashSet<>(numbers);
        if (duplicationSet.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 숫자는 중복되어선 안됩니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            checkRangeOfNumber(number);
        }
    }

    private void checkRangeOfNumber(Integer number) {
        if (number < 1 || 45 < number) {
            throw new IllegalArgumentException("[ERROR] 당첨 숫자의 범위는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
