package lotto.model;

import java.util.HashSet;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        LottoRule.validateSize(numbers.size());
        validateDuplicate(new HashSet<>(numbers).size());

        for (int number : numbers) {
            LottoRule.validateRange(number);
        }

    }

    protected void validateDuplicate(int size) {
        if (size != LottoRule.SIZE.getValue()) {
            throw new IllegalArgumentException("중복된 로또 번호가 존재합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
