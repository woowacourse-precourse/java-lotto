package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final Set<Integer> numbers;

    public Set<Integer> getNumbers() {
        return numbers;
    }

    public Lotto(List<Integer> unValidatedNumbers) {
        Collections.sort(unValidatedNumbers);
        this.numbers = new LinkedHashSet<>(unValidatedNumbers);
        validateSixNumber(numbers);
    }

    private void validateSixNumber(Set<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Error.IS_NOT_SIX.getMessage());
        }
    }

}
