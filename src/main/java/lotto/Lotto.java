package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public String getNumbersToString() {
        return numbers.toString();
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicatedNumberValidate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void duplicatedNumberValidate(List<Integer> numbers) {
        Set<Integer> noDuplicateNumbers = new HashSet<>(numbers);
        if (!(numbers.size()==noDuplicateNumbers.size())) {
            throw new IllegalArgumentException();
        }
    }

    public void sort() {
        Collections.sort(numbers);
    }

    public boolean contains(int inputNumber) {
        return numbers.contains(inputNumber);
    }
}
