package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        isValidSize(numbers);
        isDup(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void isValidSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 숫자 6개를 초과할 수 없습니다.");
        }
    }

    private void isDup(List<Integer> numbers) {
        Set<Integer> dupCheck = new HashSet<>(numbers);
        if (dupCheck.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 숫자는 중복될 수 없습니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

// TODO: 추가 기능 구현
}