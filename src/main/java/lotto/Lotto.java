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
            throw new IllegalArgumentException(ErrorMessage.ERROR_SIZE_IS_NOT_SIX);
        }
        for (Integer number : numbers) {
            if (!(1 <= number && number <= 45)) {
                throw new IllegalArgumentException(ErrorMessage.ERROR_RANGE_OUT);
            }
        }
        Set<Integer> isUnique = new HashSet<>(numbers);
        if (isUnique.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_UNIQUE);
        }

    }


}
