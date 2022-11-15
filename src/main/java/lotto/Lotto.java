package lotto;

import java.util.Collections;
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
            throw new IllegalArgumentException();
        }
        duplicateCheck(numbers);
    }
    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }


    private void duplicateCheck(List<Integer> numbers) {
        Set<Integer> duplicateChecker = new HashSet<>();
        for (Integer number : numbers) {
            if (!duplicateChecker.add(number)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호 중 중복이 존재하면 안됩니다.");
            }
        }
    }
}
