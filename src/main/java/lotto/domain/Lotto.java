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
            throw new IllegalArgumentException();
        }
    }

    private void validateSize(List<Number> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return "[" +
                numbers.get(0).getLottoNumber() + ", " +
                numbers.get(1).getLottoNumber() + ", " +
                numbers.get(2).getLottoNumber() + ", " +
                numbers.get(3).getLottoNumber() + ", " +
                numbers.get(4).getLottoNumber() + ", " +
                numbers.get(5).getLottoNumber() +
                "]";
    }
}
