package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR]: lotto numbers size error");
        }
    }

    // TODO: 추가 기능 구현
    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if(nonDuplicateNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR]: lotto numbers duplicated error");
        }
    }

    private void validateRange(List<Integer> numbers) {
        for(int number : numbers) {
            if(number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR]: lotto number range error");
            }
        }
    }
}
