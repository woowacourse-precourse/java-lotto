package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public boolean hasNumber(Integer number) {
        return numbers.contains(number);
    }
}
