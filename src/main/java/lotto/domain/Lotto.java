package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateDuplicate(List<Integer> numbers) throws IllegalArgumentException{
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            System.out.println(ExceptionMessage.DUPLICATE_NUM_LOTTO.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private void validateSize(List<Integer> numbers) throws IllegalArgumentException{
        if (numbers.size() != Constants.LOTTO_LENGTH) {
            System.out.println(ExceptionMessage.LENGTH.getMessage());
            throw new IllegalArgumentException();
        }
    }
}
