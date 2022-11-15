package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Number> numbers;

    public Lotto(List<Number> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    public List<Number> getNumbers() {
        return numbers;
    }

    private void validateDuplicate(List<Number> numbers) {
        Set<Integer> duplicateCheck = new HashSet<>();
        for (Number number : numbers) {
            duplicateCheck.add(number.getLottoNumber());
        }
        if (duplicateCheck.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    private void validateSize(List<Number> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호 개수는 총 6개여야 합니다.");
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
