package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSizeOfNumbers(numbers);
        validateDuplicateNumbers(numbers);
    }

    private void validateSizeOfNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 로또 번호는 6개의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        HashSet<Integer> setOfNumbers = new HashSet<>(numbers);
        if (setOfNumbers.size() != numbers.size()) {
            System.out.println("[ERROR] 로또 번호는 중복되지 않은 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }
}
