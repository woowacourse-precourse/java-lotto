package lotto.domain;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public List<Integer> sortLottoNumbers() {
        return this.numbers.stream().sorted().collect(Collectors.toList());
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        HashSet<Integer> duplicationChecker = new HashSet<>(numbers);

        if (duplicationChecker.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }
}
