package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream().sorted().collect(Collectors.toList());;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개가 입력되지 않았습니다");
        }

        if (new HashSet<Integer>(numbers).size() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복된 값이 존재합니다");
        }
    }

    // TODO: 추가 기능 구현
}
