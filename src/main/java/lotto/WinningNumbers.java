package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbers {
    private List<Integer> numbers;

    public WinningNumbers(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자가 6개여야 합니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (!numbers.stream().allMatch(number -> number > 0 && number < 46))
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if (nonDuplicateNumbers.size() != 6)
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복된 숫자가 없어야 합니다.");
    }

}
