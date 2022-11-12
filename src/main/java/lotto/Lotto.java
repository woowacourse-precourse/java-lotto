package lotto;

import constant.LottoRule;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoRule.SIZE.getValue()) {
            throw new IllegalArgumentException("값의 길이가 " + LottoRule.SIZE + "를 넘습니다.");
        }

        if (new HashSet<>(numbers).size() != LottoRule.SIZE.getValue()) {
            throw new IllegalArgumentException("중복된 값이 있습니다.");
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
