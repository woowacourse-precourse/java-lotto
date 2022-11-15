package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.view.ExceptionMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkUniqueNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void checkUniqueNumbers(List<Integer> numbers) {
        List<Integer> uniqueNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());

        if (numbers.size() != uniqueNumbers.size()) {
            ExceptionMessage.overlabNumberError();
            throw new IllegalArgumentException();
        }
    }
}
