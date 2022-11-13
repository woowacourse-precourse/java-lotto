package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotto {
    private static final int LOTTO_START = 1;
    private static final int LOTTO_END = 45;
    private static final int LOTTO_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public int count(Lotto other) {
        return (int) other.numbers.stream()
                .filter(this::checkContains)
                .count();
    }

    protected boolean checkContains(int number) {
        return numbers.contains(number);
    }

    protected void checkLottoRange(Integer number) {
        if (number < LOTTO_START || number > LOTTO_END) {
            throw new IllegalArgumentException();
        }
    }

    private void validate(List<Integer> numbers) {
        checkLottoSize(numbers);
        List<Integer> copyNumbers = new ArrayList<>(numbers);
        for (Integer number : copyNumbers) {
            checkDuplicateNumber(copyNumbers, number);
            checkLottoRange(number);
        }
    }

    private static void checkDuplicateNumber(List<Integer> numbers, Integer number) {
        if (numbers.indexOf(number) != numbers.lastIndexOf(number)) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
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
}
