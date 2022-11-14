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
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 개수는 6개가 아닙니다");
        }
        if (isDuplicate(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다");
        }
    }

    private boolean isDuplicate(List<Integer> numbers) {
        Set<Integer> eliminateDuplication = new HashSet<>(numbers);
        if (numbers.size() != eliminateDuplication.size()) {
            return true;
        }
        return false;
    }
}
