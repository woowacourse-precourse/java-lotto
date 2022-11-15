package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet();
        
        for (Integer number : numbers) {
            
            if (uniqueNumbers.contains(number)) {
                throw new IllegalArgumentException();
            }
            
            uniqueNumbers.add(number);
        }
    }
}
