package lotto.domain;

import java.util.List;
import java.util.Objects;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
        this.numbers = List.copyOf(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] Must enter 6 lottery winning numbers.");
        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream()
                .distinct()
                .count() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] Must enter non-duplicate numbers.");
        }
    }

    private static void validateRange(List<Integer> numbers) {
        if (numbers.stream()
                .anyMatch(Lotto::inRange)) {
            throw new IllegalArgumentException("[ERROR] Must enter a number from 1 to 45.");
        }
    }

    private static boolean inRange(int number) {
        return number < START_NUMBER || number > END_NUMBER;
    }

    public List<Integer> get(){
        return List.copyOf(numbers);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) object;
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
