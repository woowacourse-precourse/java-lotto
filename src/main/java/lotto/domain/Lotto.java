package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
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
    }

    private List<Integer> getSortedNumbers() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        List<Integer> sortedNumbers = getSortedNumbers();

        for (int number : sortedNumbers) {
            sb.append(number).append(',').append(' ');
        }
        sb.delete(sb.length() - 2, sb.length()).append(']');

        return sb.toString();
    }
}
