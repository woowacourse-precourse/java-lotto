package lotto.domain;

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
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6자리 숫자입니다.");
        }
        if (dupCheck(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복 된 숫자가 있습니다.");
        }
    }

    private boolean dupCheck(List<Integer> numbers) {
        Set<Integer> numSet = new HashSet<>(numbers);

        return numbers.size() != numSet.size();
    }
}
