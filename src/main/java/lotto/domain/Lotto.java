package lotto.domain;

import java.util.HashSet;
import java.util.List;

import static lotto.view.Constants.*;

public class Lotto {

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != COUNT) {
            throw new IllegalArgumentException(NOT_SIX);
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        HashSet<Integer> noRepetition = new HashSet<>(numbers);
        int numbersSize = numbers.size();
        int noRepetitionSize = noRepetition.size();
        if (numbersSize != noRepetitionSize) {
            throw new IllegalArgumentException(DUPLICATED_VALUE);
        }
    }
}
