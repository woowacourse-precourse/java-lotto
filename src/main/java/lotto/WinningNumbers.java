package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {
    private final List<Integer> numbers;

    public WinningNumbers(List<Integer> numbers) {
        validate(numbers);
        checkOverlap(numbers);
        checkScope(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("입력한 숫자 개수가 6개가 아닙니다.");
        }
    }

    private void checkOverlap(List<Integer> numbers) {
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        validate(distinctNumbers);
    }

    public void checkScope(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("1부터 45사이의 숫자를 입력하세요.");
            }
        }
    }
}
