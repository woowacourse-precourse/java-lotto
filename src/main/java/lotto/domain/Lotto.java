package lotto.domain;



import java.util.List;
import java.util.stream.Collectors;

import static lotto.utils.Exceptions.checkDuplicated;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers = sorted(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkDuplicated(numbers);
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public Boolean contains(int value){
        return numbers.contains(value);
    }

    public List<Integer> sorted(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
