package lotto.generation;

import lotto.exception.IllegalArgument;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 1부터 45까지의 숫자 6개를 입력하세요.");
        }
        if (IllegalArgument.isRedundancy(numbers)) {
            throw new IllegalArgumentException("[ERROR] 1부터 45까지의 중복되지 않는 숫자만 입력 가능합니다.");
        }
    }

    public List<Integer> getNumbers() {
        List<Integer> numbers = new ArrayList<>();
        numbers.addAll(this.numbers);
        Collections.sort(numbers);
        return numbers;
    }
}
