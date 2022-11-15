package lotto.vo;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또번호 생성 오류");
        }
    }

    @Override
    public String toString() {
        return numbers.stream()
            .sorted()
            .collect(Collectors.toList())
            .toString();
    }
}
