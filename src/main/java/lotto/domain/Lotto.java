package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.NumberValidate.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        countSixValidate(numbers);
        duplicateValidate(numbers);
        numbersInRangeValidate(numbers);
        this.numbers = numbersSort(numbers);
    }

    private List<Integer> numbersSort(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    public String toString() {
        return numbers.toString();
    }
    // TODO: 추가 기능 구현
}
