package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 생성 된 로또가 6개의 숫자가 아닙니다.");
        }
        HashSet<Integer> numbersSet = new HashSet<>(numbers);
        if (numbersSet.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 생성 된 로또에 중복된 숫자가 존재합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
