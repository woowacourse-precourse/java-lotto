package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.SIZE_IS_NOT_SIX.toString());
        }
        for (Integer number : numbers) {
            if (!(1 <= number && number <= 45)) {
                throw new IllegalArgumentException(ErrorMessage.RANGE_OUT.toString());
            }
        }
        Set<Integer> isUnique = new HashSet<>(numbers);
        if (isUnique.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.NOT_UNIQUE.toString());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
