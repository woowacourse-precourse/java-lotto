package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR]로또 번호의 개수가 6개가 아닙니다");
        }

        if (checkDuplicate(numbers)) {
            throw new IllegalArgumentException("[ERROR]중복입니다.");
        }
    }

    private boolean checkDuplicate(List<Integer> numbers) {
        long distinctSize = numbers.stream()
                .distinct()
                .count();
        return numbers.size() != distinctSize;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int compareNumbers(List<Integer> numbers) {
        numbers.retainAll(this.numbers);
        return numbers.size();
    }
}
