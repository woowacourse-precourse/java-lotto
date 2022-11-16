package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        InRange(numbers);
        isNotDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public boolean Contain(int number) {
        if (numbers.contains(number)) {
            return true;
        }
        return false;
    }

    private void InRange(List<Integer> numbers) {
        if (Collections.max(numbers) > 45) {
            throw new IllegalArgumentException("로또 번호가 45를 넘어 범위를 벗어났습니다.");
        }
        if (Collections.min(numbers) < 1) {
            throw new IllegalArgumentException("로또 번호가 1보다 작아 범위를 벗어났습니다.");
        }
    }

    private static void isNotDuplicate(List<Integer> numbers) {
        List<Integer> checknumbers = new ArrayList<>();
        for (int number : numbers) {
            if (checknumbers.contains(number)) {
                throw new IllegalArgumentException("로또 번호 내 중복이 존재합니다.");
            }
            checknumbers.add(number);
        }
    }
}
