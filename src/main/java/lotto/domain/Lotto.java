package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Lotto {

    private final List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개 이여야 합니다.");
        }
        Set<Integer> lottoNums = new HashSet<>(numbers);
        if (numbers.size() != lottoNums.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복값이 존재합니다.");
        }
    }
}
