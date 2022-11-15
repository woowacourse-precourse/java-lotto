package lotto.model;

import lotto.enums.Error;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        isDuplicate(numbers);
        List<Integer> sortedLotto = new ArrayList<>(numbers);
        Collections.sort(sortedLotto);
        this.numbers = sortedLotto;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Error.SIZE.getError());
        }
    }
    private void isDuplicate(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != numbers.size()) {
            throw new IllegalArgumentException(Error.DUPLICATE.getError());
        }
    }
    public List<Integer> getLotto() {
        return this.numbers;
    }
}
