package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6자리 수입니다.");
        }

        for (int i = 1; i <= 45; i++)
            if (Collections.frequency(numbers, i) >= 2) throw new IllegalArgumentException("[ERROR] 중복되는 숫자가 없어야 합니다.");

        for (int i = 0; i < 6; i++)
            if (numbers.get(i) < 1 || numbers.get(i) > 45) throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현
}
