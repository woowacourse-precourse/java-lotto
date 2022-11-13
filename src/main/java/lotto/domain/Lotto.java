package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (1 > number || number > 45) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (deDuplication(numbers) != 6) {
            throw new IllegalArgumentException();
        }
    }

    private long deDuplication(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count();
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static Lotto from(String numbers) {
        try {
            return new Lotto(convertToList(numbers));
        } catch (RuntimeException ex) {
            throw new IllegalArgumentException();
        }
    }

    private static List<Integer> convertToList(String numbers) {
        return Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
