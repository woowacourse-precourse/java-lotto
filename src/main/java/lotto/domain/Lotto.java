package lotto.domain;

import lotto.util.LottoConstant;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    public boolean isContain(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getSortedByAscend() {
        return numbers.stream()
                .sorted(Comparator.comparing(Integer::valueOf))
                .collect(Collectors.toList());
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != LottoConstant.NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException();
        }
    }
}
