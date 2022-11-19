package lotto.domain;

import lotto.constants.ErrorMessages;
import lotto.util.Validator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    public static final int LOTTO_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        if (Validator.checkSize(numbers)) {
            throw new IllegalArgumentException(ErrorMessages.SIZE);
        }

        if (Validator.hasDuplicate(numbers)) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE);
        }

        if (Validator.checkRange(numbers)) {
            throw new IllegalArgumentException(ErrorMessages.RANGE);
        }
    }

    public int matchCount(List<Integer> winningNumbers) {
        List<Integer> correct = new ArrayList<>(winningNumbers);
        correct.retainAll(numbers);
        return correct.size();
    }

    public boolean containsBonus(int bonus) {
        return numbers.contains(bonus);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
