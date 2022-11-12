package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6
                || isCheckDuplication(numbers)
                || isCheckWrongRange(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private boolean isCheckDuplication(List<Integer> numbers) {
        Set<Integer> check = new HashSet<Integer>(numbers);
        return check.size() != numbers.size();
    }

    private boolean isCheckWrongRange(List<Integer> numbers) {
        for (int i : numbers) {
            if (i < 1 || i > 45) {
                return true;
            }
        }
        return false;
    }
}
