package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != Application.COUNT) {
            throw new IllegalArgumentException("로또 번호는 6개입니다.");
        }
        for (int i = 0; i < Application.COUNT; i++) {
            if (!(Application.START_INCLUSIVE <= numbers.get(i) && numbers.get(i) <= Application.END_INCLUSIVE)) {
                throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
        Set<Integer> noDuplicate = new HashSet<>(numbers);
        if (noDuplicate.size() != numbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복되지 않아야 합니다.");
        }
    }

    public List<Integer> getLottoNumber() {
        return numbers;
    }
}