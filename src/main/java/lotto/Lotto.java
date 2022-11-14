package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        NumberValidate.countSixValidate(numbers);
        NumberValidate.duplicateValidate(numbers);
        NumberValidate.inRangeValidate(numbers);
        this.numbers = numbersSort(numbers);
    }

    private List<Integer> numbersSort(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public String toString() {
        return numbers.toString();
    }
    // TODO: 추가 기능 구현
}
