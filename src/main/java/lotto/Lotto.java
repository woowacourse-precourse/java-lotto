package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        try {
            validate(numbers);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 개수는 6개여야 합니다.");
        }
        validateRange(numbers);
        validateDuplicate(numbers);

        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (!numbers.stream().allMatch(number -> number > 0 && number < 46))
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if (nonDuplicateNumbers.size() != 6)
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복된 숫자가 없어야 합니다.");
    }
}
