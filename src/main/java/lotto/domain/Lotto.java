package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateNumber(numbers);
        this.numbers = numbers;
    }

    public void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(PrintMessages.ERROR_SIZE.getMessage());
        }
    }

    public void validateNumber(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(PrintMessages.ERROR_NUMBER_RANGE.getMessage());
            }
        }
        Set<Integer> lottoNums = new HashSet<>(numbers);
        if (lottoNums.size() != numbers.size()) {
            throw new IllegalArgumentException(PrintMessages.ERROR_DUPLICATE.getMessage());
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
