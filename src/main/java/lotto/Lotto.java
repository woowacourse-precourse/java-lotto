package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.Constants.*;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != COUNT_NUM) {
            throw new IllegalArgumentException(ERROR + "로또 번호의 개수는" + COUNT_NUM + "개가 아닙니다");
        }
        if (isDuplicate(numbers)) {
            throw new IllegalArgumentException(ERROR + "로또 번호에 중복된 숫자가 있습니다");
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
