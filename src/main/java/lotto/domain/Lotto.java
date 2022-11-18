package lotto.domain;

import lotto.constants.ErrorMessages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessages.SIZE);
        }

        if (checkDuplicate(numbers)) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE);
        }

        if (checkRange(numbers)) {
            throw new IllegalArgumentException(ErrorMessages.RANGE);
        }
    }

    private boolean checkDuplicate(List<Integer> numbers) {
        long distinctSize = numbers.stream()
                .distinct()
                .count();
        return numbers.size() != distinctSize;
    }

    private boolean checkRange(List<Integer> numbers) {
        for (Integer i : numbers) {
            if (i < 1 || i > 45) {
                return true;
            }
        }
        return false;
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
