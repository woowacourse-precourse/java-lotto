package lotto.domain.lotto;

import lotto.error.ErrorMsg;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMsg.WRONG_LOTTO_SIZE.toString());
        }

        Set<Integer> distinctNumbers = new HashSet<>(numbers);
        if(distinctNumbers.size() != numbers.size())
            throw new IllegalArgumentException(ErrorMsg.DUPLICATE_LOTTO_NUMBER.toString());
    }
}
