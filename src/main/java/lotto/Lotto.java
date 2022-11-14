package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        List<Integer> copyNumbers = new ArrayList<>(numbers);
        sort(copyNumbers);
        this.numbers = copyNumbers;
    }

    public boolean isMatch(Bonus bonus) {
        return bonus.isMatch(numbers);
    }

    public int countMatchingNumbers(Lotto winningLotto) {
        return (int) this.numbers.stream()
                .filter(winningLotto.numbers::contains)
                .count();
    }

    public boolean isExistNumber(int number) {
        return numbers.contains(number);
    }

    private void sort(List<Integer> numbers) {
        Collections.sort(numbers);
    }

    private void validate(List<Integer> numbers) {
        Validator validator = new Validator();

        validator.validateNumberSize(numbers);
        validator.validateDuplicateNumber(numbers);
        validator.validateNumberRange(numbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
