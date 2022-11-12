package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int LENGTH_OF_LOTTO_NUM = 6;
    private static final int LOWER_LIMIT_OF_LOTTO_NUM = 1;
    private static final int UPPER_LIMIT_OF_LOTTO_NUM = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Collections.sort(numbers);
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LENGTH_OF_LOTTO_NUM) {
            throw new IllegalArgumentException("[ERROR] 6개의 로또 번호가 필요합니다.");
        }

        Set<Integer> removedNumbers = new HashSet<>(numbers);
        if (removedNumbers.size() != LENGTH_OF_LOTTO_NUM) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 존재하면 안됩니다.");
        }

        for (int number : numbers) {
            if (number < LOWER_LIMIT_OF_LOTTO_NUM || number > UPPER_LIMIT_OF_LOTTO_NUM) {
                throw new IllegalArgumentException("[ERROR] 1에서 45 사이의 숫자를 입력해야 합니다.");
            }
        }
    }
    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }
}
