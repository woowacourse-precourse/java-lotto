package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        if (!validateDuplicate(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean validateDuplicate(List<Integer> numbers) {
        long noDuplicateCount = numbers.stream()
                .distinct()
                .count();

        if (noDuplicateCount != 6) {
            return false;
        }

        return true;
    }

    public int countMatchedNumber(Lotto winningLotto) {
        return (int) numbers.stream().filter(winningLotto::containNumber).count();
    }

    protected boolean containNumber(int number) {
        return numbers.contains(number);
    }

}
