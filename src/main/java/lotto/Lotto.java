package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[Error] 6개의 숫자만 입력해야 합니다.");
        }
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[Error] 중복된 수를 입력하셨습니다.");
        }
        if (Collections.min(numbers) < 1 || 45 < Collections.max(numbers)) {
            throw new IllegalArgumentException("[Error] 1부터 45의 정수만 입력해야 합니다.");
        }
    }

    public void add(Integer number) {
        numbers.add(number);
    }
}
