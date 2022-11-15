package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lotto.Enum.Error;
import lotto.Enum.Number;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers){
        validateDuplicate(numbers);
        validateSize(numbers);
        List<Integer> sortedLotto = new ArrayList<>(numbers);
        Collections.sort(sortedLotto);
        this.numbers = sortedLotto;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != Number.SIZE.getValue()) {
            throw new IllegalArgumentException(Error.SIZE.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> numbers){
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if (nonDuplicateNumbers.size() != Number.SIZE.getValue()) {
            throw new IllegalArgumentException(Error.DUPLICATE.getMessage());
        }
    }

    public List<Integer> getLottoNumbers() {
        return this.numbers;
    }
}
