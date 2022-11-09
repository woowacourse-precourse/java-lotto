package lotto.domain;

import java.util.Comparator;
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
        Set<Integer> checkNumbers = new HashSet<>(numbers);
        if (checkNumbers.size() < 6) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않은 로또 번호 6개를 입력해 주시기 바랍니다.");
        }
    }

    @Override
    public String toString() {
        numbers.sort(Comparator.naturalOrder());
        return numbers.toString();
    }
}
