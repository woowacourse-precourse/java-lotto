package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public boolean checkBonus(int bonus) {
        return numbers.contains(bonus);
    }

    public int count(Lotto other) {
        return (int) other.numbers.stream()
                .filter(this::checkBonus)
                .count();
    }

    private void validate(List<Integer> numbers) {
        checkLottoSize(numbers);
        List<Integer> copyNumbers = new ArrayList<>(numbers);
        for (Integer number : copyNumbers) {
            checkDuplicateNumber(copyNumbers, number);
            checkLottoRange(number);
        }
    }

    private void checkLottoRange(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkDuplicateNumber(List<Integer> numbers, Integer number) {
        if (numbers.indexOf(number) != numbers.lastIndexOf(number)) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkLottoSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
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
