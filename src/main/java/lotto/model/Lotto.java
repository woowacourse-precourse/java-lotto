package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicateNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> checkNumber = new HashSet<>();
        for(Integer number : numbers) {
            if(checkNumber.contains(number)) {
                throw new IllegalArgumentException();
            }
            checkNumber.add(number);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
