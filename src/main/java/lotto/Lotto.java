package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6)
            throw new IllegalArgumentException("[Error] 당첨 번호의 개수가 맞지 않습니다.");

        for (int n : numbers) {
            if (Collections.frequency(numbers, n) != 1)
                throw new IllegalArgumentException("[Error] 중복되는 값이 존재합니다.");

            if (!(n >= 1 && n <= 45)) {
                throw new IllegalArgumentException("[Error] 입력된 당첨 번호 값의 범위가 1부터 45 사이의 값이 아닙니다.");
            }
        }
    }
}
