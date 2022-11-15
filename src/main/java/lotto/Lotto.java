package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validate2(numbers);
        validate3(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개를 입력해야 합니다.");
        }
    }

    // TODO: 추가 기능 구현

    private void validate2(List<Integer> numbers) {
        HashSet<Integer> setNumbers = new HashSet<>(numbers);
        if (setNumbers.size() != 6)
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
    }

    private void validate3(List<Integer> numbers) {
        for (Integer num : numbers) {
            if (num > 45 || num < 1)
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
