package lotto.domain;

import lotto.ui.Messages;

import java.util.List;
import java.util.stream.Collectors;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Messages.ERROR_LOTTO_SIZE.getMessage());
        }
    }

    // TODO: 추가 기능 구현
    private void validateDuplicate(List<Integer> numbers) {
        List<Integer> removeDuplicate = numbers.stream().distinct().collect(Collectors.toList());

        if (numbers.size() != removeDuplicate.size()) {
            throw new IllegalArgumentException(Messages.ERROR_LOTTO_DUPLICATE.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
